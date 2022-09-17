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

const ans = input()
  .split("")
  .map((v) => Number(v) ** 5)
  .reduce((ac, v) => ac + v, 0);

console.log(ans);
