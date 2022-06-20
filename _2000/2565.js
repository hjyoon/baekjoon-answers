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
const A = Array(N);
for (let i = 0; i < N; i++) {
  const tmp = input().split(" ").map(Number);
  A[i] = tmp;
}

const B = A.sort((a, b) => a[0] - b[0]).map((v) => v[1]);
const dp = Array(N).fill(0);
let max = 0;
for (let i = 0; i < N; i++) {
  let tmp = 1;
  // console.error(`i = ${i}`);
  for (let j = 0; j < i; j++) {
    if (B[i] > B[j]) {
      tmp = Math.max(tmp, dp[j] + 1);
      // console.error(`tmp = ${tmp}`);
    }
  }
  dp[i] = tmp;
  max = Math.max(max, dp[i]);
}

// console.log(B);
// console.log(dp);
console.log(N - max);
