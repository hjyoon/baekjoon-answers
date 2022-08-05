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
const S = input().split(" ").map(Number);
const dp = [...Array(N + 1)].map(() => Array(N + 1).fill(0));

for (let i = 1; i <= N; i++) {
  dp[i][i] = 1;
}

for (let i = 1; i <= N - 1; i++) {
  if (S[i - 1] == S[i]) {
    dp[i][i + 1] = 1;
  }
}

let start = 1;
let end = 3;
let tmp_end = end;
while (end <= S.length) {
  if (dp[start + 1][tmp_end - 1] == 1 && S[start - 1] == S[tmp_end - 1]) {
    dp[start][tmp_end] = 1;
  }
  tmp_end++;
  start++;
  if (tmp_end > S.length) {
    start = 1;
    tmp_end = ++end;
  }
}

const M = Number(input());
const ans = Array(M);
for (let i = 0; i < M; i++) {
  const [start, end] = input().split(" ").map(Number);
  ans[i] = dp[start][end];
}

console.log(ans.join("\n"));
