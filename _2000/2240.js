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

// 처음 위치는 1번 자두나무

const [T, W] = input().split(" ").map(Number);
const A = [...Array(T)].map(() => Number(input()));

// 각 차원의 0번째 인덱스는 padding
// dp[현재위치][시간][움직인횟수]
const dp = [...Array(2)].map(() =>
  [...Array(T + 1)].map(() => Array(W + 2).fill(0))
);

for (let i = 1; i <= T; i++) {
  for (let j = 1; j <= W + 1; j++) {
    // 자두가 1번 자두나무에 떨어질 경우
    if (A[i - 1] == 1) {
      dp[0][i][j] = Math.max(dp[0][i - 1][j] + 1, dp[1][i - 1][j - 1] + 1);
      dp[1][i][j] = Math.max(dp[0][i - 1][j - 1], dp[1][i - 1][j]);
    }
    // 자두가 2번 자두나무에 떨어질 경우
    else {
      // 첫 번째 자두인 경우 움직여야 하므로 스킵
      if (i == 1 && j == 1) continue;
      dp[0][i][j] = Math.max(dp[0][i - 1][j], dp[1][i - 1][j - 1]);
      dp[1][i][j] = Math.max(dp[0][i - 1][j - 1] + 1, dp[1][i - 1][j] + 1);
    }
  }
}

let ans = 0;
for (let i = 0; i <= W + 1; i++) {
  ans = Math.max(dp[0][T][i], dp[1][T][i]);
}

console.log(ans);
