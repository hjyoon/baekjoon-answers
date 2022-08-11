"strict mode";
const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const N = Number(input());
const S = [...Array(N)].map(() => input().split(" ").map(Number));
const dp = [...Array(N + 1)].map(() => Array(5).fill(0));
let max_cnt = 0;
let grade;

for (let i = 1; i <= N; i++) {
  const [A, B] = S[i - 1].map((v) => v - 1);
  dp[i][A] = dp[i - 1][A] + 1;
  dp[i][B] = dp[i - 1][B] + 1;
  if (max_cnt < dp[i][A]) {
    max_cnt = dp[i][A];
    grade = A + 1;
  }
  if (max_cnt < dp[i][B]) {
    max_cnt = dp[i][B];
    grade = B + 1;
  }
  if (max_cnt == dp[i][A] && grade > A + 1) {
    grade = A + 1;
  }
  if (max_cnt == dp[i][B] && grade > B + 1) {
    grade = B + 1;
  }
}

// console.log(S);
// console.log(dp);
console.log(max_cnt, grade);
