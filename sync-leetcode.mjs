import { LeetCode, Credential } from "@leetnotion/leetcode-api";
import fs from "fs";
import path from "path";

const SESSION = process.env.LEETCODE_SESSION;

if (!SESSION) {
  throw new Error("LEETCODE_SESSION secret is missing.");
}

const OUTPUT_DIR = "LeetCode-Questions";

const credential = new Credential();
await credential.init(SESSION);

const leetcode = new LeetCode(credential);

console.log("Fetching your LeetCode submissions...");

const submissions = await leetcode.submissions({
  limit: 100,
  offset: 0,
});

if (!submissions) {
  throw new Error("Could not fetch submissions from LeetCode.");
}

console.log(`Fetched ${submissions.length} submissions.`);

fs.mkdirSync(OUTPUT_DIR, { recursive: true });

let added = 0;

for (const submission of submissions) {
  if (submission.statusDisplay !== "Accepted") {
    continue;
  }

  const title = submission.title;
  const titleSlug = submission.titleSlug;
  const submissionId = submission.id;

  if (!title || !titleSlug || !submissionId) {
    continue;
  }

  const safeTitle = title.replace(/[<>:"/\\|?*]/g, "");
  const filePath = path.join(
    OUTPUT_DIR,
    `${safeTitle}.java`
  );

  if (fs.existsSync(filePath)) {
    continue;
  }

  console.log(`Fetching code: ${title}`);

  try {
    const details = await leetcode.submission(submissionId);

    if (!details || !details.code) {
      console.log(`No source code found for ${title}`);
      continue;
    }

    let extension = "txt";

    if (details.lang?.name === "Java") {
      extension = "java";
    } else if (details.lang?.name === "Python") {
      extension = "py";
    } else if (details.lang?.name === "C++") {
      extension = "cpp";
    } else if (details.lang?.name === "JavaScript") {
      extension = "js";
    }

    const finalPath = path.join(
      OUTPUT_DIR,
      `${safeTitle}.${extension}`
    );

    fs.writeFileSync(finalPath, details.code);

    console.log(`Added: ${finalPath}`);
    added++;

  } catch (error) {
    console.log(`Failed to fetch ${title}: ${error.message}`);
  }
}

console.log(`Finished. Added ${added} new solution(s).`);
