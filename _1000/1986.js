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

const q_chk = (y, x) => {
  const dy = [-1, -1, 0, 1, 1, 1, 0, -1];
  const dx = [0, 1, 1, 1, 0, -1, -1, -1];
  for (let i = 0; i < 8; i++) {
    let [cur_y, cur_x] = [y, x];
    while (1) {
      cur_y += dy[i];
      cur_x += dx[i];
      if (cur_y < 0 || cur_y >= n) {
        break;
      }
      if (cur_x < 0 || cur_x >= m) {
        break;
      }
      if (
        board[cur_y][cur_x] == "P" ||
        board[cur_y][cur_x] == "Q" ||
        board[cur_y][cur_x] == "K"
      ) {
        break;
      }
      board[cur_y][cur_x] = "X";
    }
  }
};

const k_chk = (y, x) => {
  const dy = [-2, -1, 1, 2, 2, 1, -1, -2];
  const dx = [1, 2, 2, 1, -1, -2, -2, -1];
  for (let i = 0; i < 8; i++) {
    let [cur_y, cur_x] = [y, x];
    cur_y += dy[i];
    cur_x += dx[i];
    if (cur_y < 0 || cur_y >= n) {
      continue;
    }
    if (cur_x < 0 || cur_x >= m) {
      continue;
    }
    board[cur_y][cur_x] = "X";
  }
};

const [n, m] = input().split(" ").map(Number);
const board = [...Array(n)].map(() => Array(m).fill(" "));

const [cnt_q, ...q_arr] = input().split(" ").map(Number);
const [cnt_k, ...k_arr] = input().split(" ").map(Number);
const [cnt_p, ...p_arr] = input().split(" ").map(Number);

for (let i = 0; i < q_arr.length; i += 2) {
  board[q_arr[i] - 1][q_arr[i + 1] - 1] = "Q";
}

for (let i = 0; i < k_arr.length; i += 2) {
  board[k_arr[i] - 1][k_arr[i + 1] - 1] = "K";
}

for (let i = 0; i < p_arr.length; i += 2) {
  board[p_arr[i] - 1][p_arr[i + 1] - 1] = "P";
}

for (let i = 0; i < q_arr.length; i += 2) {
  q_chk(q_arr[i] - 1, q_arr[i + 1] - 1);
}

for (let i = 0; i < k_arr.length; i += 2) {
  k_chk(k_arr[i] - 1, k_arr[i + 1] - 1);
}

let ans = 0;

for (let i = 0; i < n; i++) {
  for (let j = 0; j < m; j++) {
    if (board[i][j] == " ") {
      ans++;
    }
  }
}

console.log(ans);
