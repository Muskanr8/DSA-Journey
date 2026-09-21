import fs from "node:fs";
import path from "node:path";
import { execSync } from "node:child_process";
import { LeetCode, Credential } from "leetcode-query";

const DEST = "LeetCode-Questions";
const SESSION = process.env.LEETCODE_SESSION;

if (!SESSION) {
  throw new Error("LEETCODE_SESSION secret is missing.");
}

const credential = new Credential();
await credential.init(SESSION);

const leetcode = new LeetCode(credential);

console.log("Fetching recent LeetCode submissions...");

const result = await leetcode.submissions({
  limit: 20,
  offset: 0,
});

const submissions = result?.submissions ?? result ?? [];

console.log(`Found ${submissions.length} submissions.`);

fs.mkdirSync(DEST, { recursive: true });

let added = 0;

for (const submission of submissions) {
  if (submission.statusDisplay !== "Accepted") continue;

  const id = submission.id;

  console.log(
    `Accepted: ${submission.title ?? submission.titleSlug} (${submission.lang})`
  );

  let detail;

  try {
    detail = await leetcode.submission(id);
  } catch {
    console.log(`Could not fetch submission details for ${id}`);
    continue;
  }

  if (!detail?.code) {
    console.log(`No source code returned for submission ${id}`);
    continue;
  }

const titleSlug =
  submission.titleSlug ??
  detail.question?.titleSlug ??
  `submission-${id}`;

const questionResponse = await fetch("https://leetcode.com/graphql", {
  method: "POST",
  headers: {
    "Content-Type": "application/json",
    Cookie: `LEETCODE_SESSION=${SESSION}`,
  },
  body: JSON.stringify({
    operationName: "questionData",
    variables: {
      titleSlug,
    },
    query: `
      query questionData($titleSlug: String!) {
        question(titleSlug: $titleSlug) {
          questionFrontendId
          title
          titleSlug
        }
      }
    `,
  }),
});

const questionData = await questionResponse.json();

const questionId =
  questionData?.data?.question?.questionFrontendId ?? "unknown";

  const language = String(detail.lang ?? submission.lang ?? "").toLowerCase();

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

  const filename = `${questionId}-${titleSlug}.${extension}`;
  const filePath = path.join(DEST, filename);

  if (fs.existsSync(filePath)) {
    console.log(`Already exists: ${filename}`);
    continue;
  }

  fs.writeFileSync(filePath, detail.code + "\n", "utf8");

  console.log(`Added: ${filePath}`);
  added++;
}

console.log(`Finished. Added ${added} new solution(s).`);

if (added > 0) {
  execSync("git config user.name 'github-actions[bot]'");
  execSync(
    "git config user.email '41898282+github-actions[bot]@users.noreply.github.com'"
  );

  execSync("git add LeetCode-Questions");

  try {
    execSync(
      'git commit -m "[LeetCode Sync] Add accepted solutions"',
      { stdio: "inherit" }
    );

    execSync("git push", { stdio: "inherit" });

    console.log("Successfully pushed solutions to GitHub.");
  } catch {
    console.log("Nothing new to commit.");
  }
}
