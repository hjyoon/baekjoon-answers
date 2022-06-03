const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

let T = 0;
while (1) {
  T++;
  const N = Number(input());
  if (N == 0) {
    break;
  }
  const board = [];
  const dp = [];
  for (let i = 0; i < N; i++) {
    const tmp = input().split(" ").map(Number);
    board.push(tmp);
    dp.push([0, 0, 0]);
  }
  dp[0][0] = Infinity;
  dp[0][1] = board[0][1];
  dp[0][2] = Infinity;
  if (board[0][2] < 0) {
    dp[0][2] = dp[0][1] + board[0][2];
  }

  for (let i = 1; i < N; i++) {
    for (let j = 0; j < 3; j++) {
      const tmp = [];
      if (j - 1 >= 0) {
        tmp.push(dp[i][j - 1]);
        tmp.push(dp[i - 1][j - 1]);
      }
      tmp.push(dp[i - 1][j]);
      if (j + 1 <= 2) tmp.push(dp[i - 1][j + 1]);
      const min = Math.min(...tmp);
      dp[i][j] = board[i][j] + min;
    }
  }
  console.log(`${T}. ${dp[N - 1][1]}`);
}
