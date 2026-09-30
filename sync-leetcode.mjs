import fs from "node:fs";
import path from "node:path";
import { execSync } from "node:child_process";

const DEST = "LeetCode-Questions";

const SESSION = process.env.LEETCODE_SESSION;
const CSRF = process.env.LEETCODE_CSRF_TOKEN;

if (!SESSION) {
  throw new Error("LEETCODE_SESSION secret is missing.");
}

if (!CSRF) {
  throw new Error("LEETCODE_CSRF_TOKEN secret is missing.");
}

const GRAPHQL_URL = "https://leetcode.com/graphql";

const cookie = `LEETCODE_SESSION=${SESSION}; csrftoken=${CSRF}`;

async function graphql(query, variables, operationName) {
  const response = await fetch(GRAPHQL_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Cookie: cookie,
      "X-CSRFToken": CSRF,
      Referer: "https://leetcode.com/",
      "User-Agent": "Mozilla/5.0",
    },
    body: JSON.stringify({
      operationName,
      variables,
      query,
    }),
  });

  if (!response.ok) {
    throw new Error(
      `LeetCode GraphQL request failed: HTTP ${response.status}`
    );
  }

  const data = await response.json();

  if (data.errors) {
    throw new Error(JSON.stringify(data.errors));
  }

  return data.data;
}

const username = "Muskanr8";

console.log(`LeetCode user: ${username}`);
console.log("Fetching recent accepted LeetCode submissions...");

const recentSubmissionsQuery = `
  query recentAcSubmissionList($username: String!, $limit: Int!) {
    recentAcSubmissionList(username: $username, limit: $limit) {
      id
      title
      titleSlug
      timestamp
    }
  }
`;

const submissionData = await graphql(
  recentSubmissionsQuery,
  {
    username,
    limit: 20,
  },
  "recentAcSubmissionList"
);

const submissions = submissionData?.recentAcSubmissionList ?? [];

console.log(`Found ${submissions.length} recent accepted submissions.`);

fs.mkdirSync(DEST, { recursive: true });

let added = 0;

for (const submission of submissions) {
  const title = submission.title;
  const titleSlug = submission.titleSlug;

  console.log(`\nChecking: ${title}`);

  // ---------------------------------------------------------
  // STEP 1: Get submission history for this specific problem
  // ---------------------------------------------------------

  const submissionListQuery = `
    query submissionList(
      $offset: Int!
      $limit: Int!
      $questionSlug: String!
    ) {
      submissionList(
        offset: $offset
        limit: $limit
        questionSlug: $questionSlug
    ) {
        submissions {
          id
          statusDisplay
          lang
          timestamp
        }
      }
    }
  `;

  let submissionListData;

  try {
    submissionListData = await graphql(
      submissionListQuery,
      {
        offset: 0,
        limit: 20,
        questionSlug: titleSlug,
      },
      "submissionList"
    );
  } catch (error) {
    console.log(
      `Could not fetch submission list for ${title}: ${error.message}`
    );
    continue;
  }

  const problemSubmissions =
    submissionListData?.submissionList?.submissions ?? [];

  const acceptedSubmission = problemSubmissions.find(
    (item) => item.statusDisplay === "Accepted"
  );

  if (!acceptedSubmission) {
    console.log(`No Accepted submission found for ${title}`);
    continue;
  }

  const submissionId = Number(acceptedSubmission.id);

  console.log(`Accepted submission ID: ${submissionId}`);

  // ---------------------------------------------------------
  // STEP 2: Get the actual submitted source code
  // ---------------------------------------------------------

  const detailQuery = `
    query submissionDetails($submissionId: Int!) {
      submissionDetails(submissionId: $submissionId) {
        code
        lang {
          name
        }
        statusDisplay
      }
    }
  `;

  let detailData;

  try {
    detailData = await graphql(
      detailQuery,
      {
        submissionId,
      },
      "submissionDetails"
    );
  } catch (error) {
    console.log(
      `Could not fetch code for ${title}: ${error.message}`
    );
    continue;
  }

  const detail = detailData?.submissionDetails;

  if (!detail?.code) {
    console.log(`No source code returned for ${title}`);
    continue;
  }

  const language = String(
    detail.lang?.name ?? acceptedSubmission.lang ?? ""
  ).toLowerCase();

  const extensionMap = {
    java: "java",
    javascript: "js",
    typescript: "ts",
    python: "py",
    python3: "py",
    cpp: "cpp",
    c: "c",
    csharp: "cs",
    kotlin: "kt",
    go: "go",
    rust: "rs",
  };

  const extension = extensionMap[language] ?? "txt";

  // ---------------------------------------------------------
  // STEP 3: Get official LeetCode problem number
  // ---------------------------------------------------------

  const questionQuery = `
    query questionData($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        questionFrontendId
        title
        titleSlug
      }
    }
  `;

  let questionData;

  try {
    questionData = await graphql(
      questionQuery,
      {
        titleSlug,
      },
      "questionData"
    );
  } catch (error) {
    console.log(
      `Could not fetch problem number for ${title}: ${error.message}`
    );
    continue;
  }

  const question = questionData?.question;

  if (!question?.questionFrontendId) {
    console.log(`Could not determine problem number for ${title}`);
    continue;
  }

  const questionId = question.questionFrontendId;

  // ---------------------------------------------------------
  // STEP 4: Save solution
  // ---------------------------------------------------------

  const filename = `${questionId}-${titleSlug}.${extension}`;
  const filePath = path.join(DEST, filename);

  if (fs.existsSync(filePath)) {
    console.log(`Already exists: ${filename}`);
    continue;
  }

  fs.writeFileSync(filePath, detail.code + "\n", "utf8");

  console.log(`Added: ${filename}`);
  added++;
}

console.log(`\nFinished. Added ${added} new solution(s).`);

// ---------------------------------------------------------
// STEP 5: Commit and push
// ---------------------------------------------------------

if (added > 0) {
  execSync("git config user.name 'Muskan Shaik'");

  execSync(
    "git config user.email '129413369+Muskanr8@users.noreply.github.com'"
  );

  execSync("git add LeetCode-Questions");

  try {
    execSync(
      'git commit -m "[LeetCode Sync] Add accepted solutions"',
      { stdio: "inherit" }
    );

    execSync("git push", { stdio: "inherit" });

    console.log("Successfully pushed solutions to GitHub.");
  } catch (error) {
    console.log("Nothing new to commit.");
  }
} else {
  console.log("No new solutions to commit.");
}
