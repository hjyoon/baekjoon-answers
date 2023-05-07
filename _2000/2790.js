"strict mode";
const stdin = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const N = Number(input());
const S = [...Array(N)].map(() => Number(input()));
S.sort((a, b) => b - a);

let ans = 1;
let maxScore = S[0] + 1;

for (let i = 1; i < N; i++) {
  if (maxScore <= S[i] + N) {
    ans++;
  }
  maxScore = Math.max(maxScore, S[i] + i + 1);
}

console.log(ans);
