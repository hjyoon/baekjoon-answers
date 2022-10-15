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

const _ = input();
const A = BigInt(input());
const B = BigInt(input());
console.log(`${A * B}`);
