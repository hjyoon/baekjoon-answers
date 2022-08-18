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
const dp = Array(N).fill(Infinity);
dp[0] = 0;

for (let i = 0; i < N; i++) {
  for (let j = i + 1; j <= i + S[i]; j++) {
    if (j >= N) break;
    dp[j] = Math.min(dp[j], dp[i] + 1);
  }
}

console.log(dp[N - 1] != Infinity ? dp[N - 1] : -1);
