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

const N = Number(input());
const S = [...Array(N)].map(() => Number(input()));
let ans = 0;

let i = S.length - 1;
let target = N;
while (i >= 0) {
  if (S[i] !== target) ans++;
  else target--;
  i--;
}

console.log(ans);
