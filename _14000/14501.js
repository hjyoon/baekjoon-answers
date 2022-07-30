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

const dfs = (pos, ac) => {
  if (pos > A.length) {
    return;
  } else {
    ans = Math.max(ans, ac);
  }
  for (let i = pos; i < A.length; i++) {
    dfs(i + A[i][0], ac + A[i][1]);
  }
};

const N = Number(input());
const A = Array(N);
let ans = 0;

for (let i = 0; i < N; i++) {
  A[i] = input().split(" ").map(Number);
}

dfs(0, 0);

console.log(ans);
