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

const nums = input()
  .split(" ")
  .map(Number)
  .reduce((ac, v) => ac + v);

console.log(nums * 5);
