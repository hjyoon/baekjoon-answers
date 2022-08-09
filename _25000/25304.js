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

const X = Number(input());
const N = Number(input());
let tmp = 0;
for (let i = 0; i < N; i++) {
  const [a, b] = input().split(" ").map(Number);
  tmp += a * b;
}
if (tmp === X) {
  console.log("Yes");
} else {
  console.log("No");
}
