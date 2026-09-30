import fs from "fs";
import path from "path";

const SESSION = process.env.LEETCODE_SESSION;
const CSRF = process.env.LEETCODE_CSRF_TOKEN;

if (!SESSION) throw new Error("LEETCODE_SESSION secret is missing.");
if (!CSRF) throw new Error("LEETCODE_CSRF_TOKEN secret is missing.");

const OUTPUT_DIR = "LeetCode-Questions";
const GRAPHQL_URL = "https://leetcode.com/graphql/";

const headers = {
  "Content-Type": "application/json",
  "x-csrftoken": CSRF,
  "Referer": "https://leetcode.com/",
  "User-Agent":
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/154 Safari/537.36",
  "Cookie": `LEETCODE_SESSION=${SESSION}; csrftoken=${CSRF}`,
};

async function graphql(query, variables) {
  const response = await fetch(GRAPHQL_URL, {
    method: "POST",
    headers,
    body: JSON.stringify({
      query,
      variables,
    }),
  });

  const text = await response.text();

  if (!response.ok) {
    throw new Error(`HTTP ${response.status}: ${text}`);
  }

  const json = JSON.parse(text);

  if (json.errors) {
    throw new Error(JSON.stringify(json.errors));
  }

  return json.data;
}

// --------------------------------------------------
// 1. Get recent accepted submissions
// --------------------------------------------------

const recentQuery = `
query recentAcSubmissions($username: String!, $limit: Int!) {
  recentAcSubmissionList(username: $username, limit: $limit) {
    id
    title
    titleSlug
    timestamp
  }
}
`;

console.log("Fetching recent accepted submissions...");

const recentData = await graphql(recentQuery, {
  username: "Muskanr8",
  limit: 20,
});

const recent = recentData.recentAcSubmissionList || [];

console.log(`Found ${recent.length} recent accepted submissions.`);

fs.mkdirSync(OUTPUT_DIR, { recursive: true });

let added = 0;

// --------------------------------------------------
// 2. Find actual Accepted submission for each problem
// --------------------------------------------------

const submissionQuery = `
query submissionList(
  $offset: Int!,
  $limit: Int!,
  $lastKey: String,
  $questionSlug: String!,
  $status: Int
) {
  questionSubmissionList(
    offset: $offset,
    limit: $limit,
    lastKey: $lastKey,
    questionSlug: $questionSlug,
    status: $status
  ) {
    submissions {
      id
      status
      statusDisplay
      lang
      timestamp
    }
  }
}
`;

// --------------------------------------------------
// 3. Get source code
// --------------------------------------------------

const detailsQuery = `
query submissionDetails($submissionId: Int!) {
  submissionDetails(submissionId: $submissionId) {
    code
    statusDisplay
    lang {
      name
    }
  }
`;

for (const problem of recent) {
  const title = problem.title;
  const slug = problem.titleSlug;

  console.log(`\nProcessing: ${title}`);

  try {
    const data = await graphql(submissionQuery, {
      offset: 0,
      limit: 20,
      lastKey: null,
      questionSlug: slug,
      status: 10,
    });

    const submissions =
      data.questionSubmissionList?.submissions || [];

    const accepted = submissions.find(
      (s) => s.statusDisplay === "Accepted"
    );

    if (!accepted) {
      console.log(`No Accepted submission found for ${title}`);
      continue;
    }

    console.log(`Accepted submission ID: ${accepted.id}`);

    const detailData = await graphql(detailsQuery, {
      submissionId: Number(accepted.id),
    });

    const details = detailData.submissionDetails;

    if (!details?.code) {
      console.log(`No source code returned for ${title}`);
      continue;
    }

    const language = details.lang?.name || accepted.lang || "unknown";

    const extensions = {
      Java: "java",
      JavaScript: "js",
      TypeScript: "ts",
      Python: "py",
      "C++": "cpp",
      C: "c",
      "C#": "cs",
      Go: "go",
      Rust: "rs",
      Kotlin: "kt",
      Swift: "swift",
    };

    const extension = extensions[language] || "txt";

    const safeTitle = title.replace(/[<>:"/\\|?*]/g, "");

    const filePath = path.join(
      OUTPUT_DIR,
      `${safeTitle}.${extension}`
    );

    if (fs.existsSync(filePath)) {
      console.log(`Already exists: ${filePath}`);
      continue;
    }

    fs.writeFileSync(filePath, details.code);

    console.log(`Added: ${filePath}`);

    added++;
  } catch (error) {
    console.log(`Failed: ${title}`);
    console.log(error.message);
  }
}

console.log(`\nFinished. Added ${added} new solution(s).`);
