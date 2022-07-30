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

const dfs = (y, x) => {
  let res = 1;
  if (y < 0 || y >= N || x < 0 || x >= M) {
    return 0;
  }
  if (board[y][x] == 0) {
    return 0;
  }
  if (visit[y][x]) {
    return 0;
  }
  visit[y][x] = 1;
  for (let i = 0; i < 4; i++) {
    res += dfs(y + dy[i], x + dx[i]);
  }
  return res;
};

const [N, M, K] = input().split(" ").map(Number);
const board = [...Array(N)].map(() => Array(M).fill(0));
const visit = [...Array(N)].map(() => Array(M).fill(0));
const dy = [0, 1, 0, -1];
const dx = [1, 0, -1, 0];
let ans = 0;

for (let i = 0; i < K; i++) {
  const [R, C] = input()
    .split(" ")
    .map((v) => Number(v) - 1);
  board[R][C] = 1;
}

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (board[i][j] && visit[i][j] == 0) {
      ans = Math.max(ans, dfs(i, j));
    }
  }
}

console.log(ans);
