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

const [N, M] = input().split(" ").map(Number);

const s = new Set();
for (let i = 0; i < N; i++) {
  s.add(input());
}

let ans = 0;
for (let i = 0; i < M; i++) {
  ans += s.has(input());
}

console.log(ans);
