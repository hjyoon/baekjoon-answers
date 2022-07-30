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

// let S1 = input();
// let S2 = input();
// let S3 = input();

// if (S1.length > S2.length) {
//   [S1, S2] = [S2, S1];
// }

let [S1, S2, S3] = [input(), input(), input()].sort(
  (a, b) => a.length - b.length
);

// const shorter = Math.min(S1.length, S2.length);
// const longer = Math.max(S1.length, S2.length);

const [short, mid, long] = [S1.length, S2.length, S3.length].sort(
  (a, b) => a - b
);

const dp = [...Array(short + 1)].map(() => Array(mid + 1));
for (let i = 0; i <= short; i++) {
  for (let j = 0; j <= mid; j++) {
    dp[i][j] = Array(long + 1).fill(0);
  }
}

for (let i = 1; i <= short; i++) {
  for (let j = 1; j <= mid; j++) {
    for (let k = 1; k <= long; k++) {
      if (S1[i - 1] == S2[j - 1] && S2[j - 1] == S3[k - 1]) {
        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
      } else {
        dp[i][j][k] = Math.max(
          dp[i][j - 1][k],
          dp[i - 1][j][k],
          dp[i][j][k - 1]
        );
      }
    }
  }
}

// dp.forEach((v) => {
//   console.log(...v);
// });

console.log(dp[short][mid][long]);
