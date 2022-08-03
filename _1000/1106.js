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

const [C, N] = input().split(" ").map(Number);
const cities = [...Array(N)].map(() => input().split(" ").map(Number));
const dp = Array(C + 101).fill(Infinity);
dp[0] = undefined;

for (let i = 1; i < dp.length; i++) {
  for (const [price, people] of cities) {
    if (i - people >= 0) {
      if (dp[i - people] == undefined) {
        dp[i] = Math.min(dp[i], price);
      } else {
        dp[i] = Math.min(dp[i], dp[i - people] + price);
      }
    }
  }
}

let ans = Infinity;
for (let i = C; i < dp.length; i++) {
  ans = Math.min(ans, dp[i]);
}

// dp.forEach((v, i) => {
//   console.log(i, v);
// });

console.log(ans);
