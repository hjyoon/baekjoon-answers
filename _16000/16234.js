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

const dfs = (y, x, g) => {
  if (visit[y][x]) {
    return;
  }
  visit[y][x] = 1;
  group[y][x] = g;
  for (let i = 0; i < dy.length; i++) {
    if (y + dy[i] < 0 || y + dy[i] >= N || x + dx[i] < 0 || x + dx[i] >= N) {
      continue;
    }
    const tmp = Math.abs(board[y][x] - board[y + dy[i]][x + dx[i]]);
    if (tmp >= L && tmp <= R) {
      dfs(y + dy[i], x + dx[i], g);
    }
  }
};

const init = () => {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      group[i][j] = 0;
      visit[i][j] = 0;
      group_cur = 1;
    }
  }
};

const set_group = () => {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (!visit[i][j]) {
        dfs(i, j, group_cur);
        group_cur++;
      }
    }
  }
};

const averaging = () => {
  const group_sum = Array(group_cur).fill(0);
  const group_cell_cnt = Array(group_cur).fill(0);
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      group_sum[group[i][j] - 1] += board[i][j];
      group_cell_cnt[group[i][j] - 1]++;
    }
  }
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      board[i][j] = Math.floor(
        group_sum[group[i][j] - 1] / group_cell_cnt[group[i][j] - 1]
      );
    }
  }
};

const check_end = () => {
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (pre_board[i][j] != board[i][j]) {
        return false;
      }
    }
  }
  return true;
};

const [N, L, R] = input().split(" ").map(Number);
const dy = [0, 1, 0, -1];
const dx = [1, 0, -1, 0];
const board = [];
let pre_board;
const group = [];
const visit = [];
let ans = 0;
let group_cur = 1;
for (let i = 0; i < N; i++) {
  board.push(input().split(" ").map(Number));
  group.push(Array(N));
  visit.push(Array(N));
}

while (1) {
  init();
  set_group();
  pre_board = JSON.parse(JSON.stringify(board));
  averaging();
  if (check_end()) break;
  ans++;
}

console.log(ans);
