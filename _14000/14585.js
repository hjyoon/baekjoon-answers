"strict mode";
const assert = require("node:assert/strict");
const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const [N, M] = input().split(" ").map(Number);
const board = [...Array(301)].map(() => Array(301).fill(0));
const dp = [...Array(301)].map(() => Array(301).fill(0));
[...Array(N)].forEach(() => {
  const [y, x] = input().split(" ").map(Number);
  board[y][x] = 1;
});

for (let i = 0; i < 301; i++) {
  for (let j = 0; j < 301; j++) {
    if (board[i][j] === 1) {
      dp[i][j] = Math.max(
        ((dp[i - 1] ?? [])[j] ?? 0) + M - (i + j),
        ((dp[i] ?? [])[j - 1] ?? 0) + M - (i + j)
      );
    } else {
      dp[i][j] = Math.max((dp[i - 1] ?? [])[j] ?? 0, (dp[i] ?? [])[j - 1] ?? 0);
    }
  }
}

let ans = 0;
for (let i = 0; i < 301; i++) {
  for (let j = 0; j < 301; j++) {
    ans = Math.max(ans, dp[i][j]);
  }
}

console.log(ans);
