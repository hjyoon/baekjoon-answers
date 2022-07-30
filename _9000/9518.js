const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const find_pos = (board) => {
  let cnt = 0;
  let [max_y, max_x] = [-1, -1];
  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      if (board[i][j] == "o") {
        continue;
      }
      let tmp = 0;
      for (let k = 0; k < 8; k++) {
        if (i + dy[k] < 0 || i + dy[k] >= R) {
          continue;
        }
        if (j + dx[k] < 0 || j + dx[k] >= C) {
          continue;
        }
        if (board[i + dy[k]][j + dx[k]] == "o") {
          tmp++;
        }
      }
      if (tmp > cnt) {
        cnt = tmp;
        [max_y, max_x] = [i, j];
      }
    }
  }
  return [max_y, max_x];
};

const dy = [0, 1, 0, -1, 1, 1, -1, -1];
const dx = [1, 0, -1, 0, 1, -1, -1, 1];

const [R, C] = input().split(" ").map(Number);
const board = [...Array(R)].map(() => input().split(""));
const [pos_y, pos_x] = find_pos(board);

if (pos_y != -1 && pos_x != -1) {
  board[pos_y][pos_x] = "o";
}

const s = new Set();

for (let i = 0; i < R; i++) {
  for (let j = 0; j < C; j++) {
    for (let k = 0; k < 8; k++) {
      if (board[i][j] == ".") {
        continue;
      }
      if (i + dy[k] < 0 || i + dy[k] >= R) {
        continue;
      }
      if (j + dx[k] < 0 || j + dx[k] >= C) {
        continue;
      }
      if (board[i + dy[k]][j + dx[k]] == "o") {
        s.add([i, j, i + dy[k], j + dx[k]]);
      }
    }
  }
}

if (s.size) {
  console.log(s.size / 2);
} else {
  console.log(s.size);
}
