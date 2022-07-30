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

const dfs = (start_y, start_x, step) => {
  if (start_y < 0 || start_y >= R || start_x < 0 || start_x >= C) return;
  if (board[start_y][start_x] == "T") return;
  if (visit[start_y][start_x]) return;
  if (step > K) return;
  // console.log(start_y, start_x, step);
  if (start_y == 0 && start_x == C - 1 && step == K) {
    // console.log("good");
    ans++;
  }
  visit[start_y][start_x] = 1;
  for (const [dy, dx] of [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ]) {
    dfs(start_y + dy, start_x + dx, step + 1);
  }
  visit[start_y][start_x] = 0;
};

let ans = 0;
const [R, C, K] = input().split(" ").map(Number);
const board = [];
const visit = [...Array(R)].map(() => Array(C).fill(0));
for (let i = 0; i < R; i++) {
  board.push(input().split(""));
}

dfs(R - 1, 0, 1);

console.log(ans);
