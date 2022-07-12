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

let T = Number(input());
while (T--) {
  const N = Number(input());
  const A = [...Array(N)]
    .map(() => input().split(" ").map(Number))
    .sort((a, b) => a[0] - b[0]);
  let ans = 0;
  let min = Infinity;
  for (let i = 0; i < N; i++) {
    if (A[i][1] < min) {
      ans++;
    }
    min = Math.min(min, A[i][1]);
  }

  console.log(ans);
}
