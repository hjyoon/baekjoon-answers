const stdin = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .split("\n");

const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const [a, b] = input().split(" ").map(Number);

console.log(a + b);
