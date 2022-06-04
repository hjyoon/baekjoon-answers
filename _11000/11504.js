const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let T = input();
while (T--) {
  const [N, M] = input().split(" ").map(Number);
  const X = Number(input().split(" ").join(""));
  const Y = Number(input().split(" ").join(""));
  const tmp = input().split(" ");
  const arr = [...tmp, ...tmp];
  let res = 0;

  for (let i = 0; i < N; i++) {
    const tmp = Number(arr.slice(i, i + M).join(""));
    if (X <= tmp && tmp <= Y) {
      res++;
    }
  }

  console.log(res);
}
