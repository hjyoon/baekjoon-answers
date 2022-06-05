const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const dfs = (y, x, dy, dx, color) => {
  if ((y < 0) | (x < 0) | (y >= 6) | (x >= 6)) {
    return false;
  }
  if (board[y][x] == ".") {
    return false;
  }
  if (board[y][x] == color) {
    return true;
  }
  const res = dfs(y + dy, x + dx, dy, dx, color);
  if (res) {
    board[y][x] = color;
  }
  return res;
};

const reverse = (y, x) => {
  dy = [-1, -1, 0, 1, 1, 1, 0, -1];
  dx = [0, 1, 1, 1, 0, -1, -1, -1];
  for (let i = 0; i < 8; i++) {
    dfs(y + dy[i], x + dx[i], dy[i], dx[i], board[y][x]);
  }
};

const cnt_color = () => {
  let [black, white] = [0, 0];
  for (let i = 0; i < 6; i++) {
    for (let j = 0; j < 6; j++) {
      if (board[i][j] == "B") {
        black++;
      } else if (board[i][j] == "W") {
        white++;
      }
    }
  }
  return [black, white];
};

// init board
const board = [...Array(6)].map(() => Array(6).fill("."));
board[2][2] = "W";
board[3][3] = "W";
board[2][3] = "B";
board[3][2] = "B";

const N = input();
let turn = 0;
for (let i = 0; i < N; i++) {
  const [y, x] = input()
    .split(" ")
    .map((x) => Number(x) - 1);
  board[y][x] = ["B", "W"][turn];
  reverse(y, x);
  turn = 1 - turn;
}
const [black, white] = cnt_color();

// print board
console.log(board.map((x) => x.join("")).join("\n"));

// print winner
console.log(black > white ? "Black" : "White");
