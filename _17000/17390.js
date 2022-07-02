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

const [N, Q] = input().split(" ").map(Number);
const A = input().split(" ").map(Number);
A.sort((a, b) => a - b);
const AA = Array(N + 1);
AA[0] = 0;
for (let i = 1; i <= N; i++) {
  AA[i] = AA[i - 1] + A[i - 1];
}

const ans = Array(Q);
for (let i = 0; i < Q; i++) {
  const [L, R] = input()
    .split(" ")
    .map((v) => Number(v));
  ans[i] = AA[R] - AA[L - 1];
}

console.log(ans.join("\n"));
