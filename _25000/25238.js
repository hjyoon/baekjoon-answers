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

const [a, b] = input().split(" ").map(Number);

if (a * ((100 - b) / 100) >= 100) {
  console.log(0);
} else {
  console.log(1);
}
