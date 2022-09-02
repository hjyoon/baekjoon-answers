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
S.sort((a, b) => a - b);
console.log(S[Math.floor((S.length - 1) / 2)]);
