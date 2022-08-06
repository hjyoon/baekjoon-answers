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

const move_one = (y, x, s, d, size) => {
  let [new_y, new_x] = [
    y + d_pos[d][0] * (s % size),
    x + d_pos[d][1] * (s % size),
  ];
  if (new_y >= size) {
    new_y %= size;
  }
  if (new_x >= size) {
    new_x %= size;
  }
  if (new_y < 0) {
    new_y += size;
  }
  if (new_x < 0) {
    new_x += size;
  }
  return [new_y, new_x];
};

const move_all = () => {
  const new_board = [...Array(N)].map(() => [...Array(N)].map(() => []));
  for (let yi = 0; yi < N; yi++) {
    for (let xi = 0; xi < N; xi++) {
      for (const [m, s, d] of board[yi][xi]) {
        const [tmp_y, tmp_x] = move_one(yi, xi, s, d, N);
        new_board[tmp_y][tmp_x].push([m, s, d]);
      }
    }
  }
  return new_board;
};

const cal_d = (items) => {
  if (items.every((e) => e[2] % 2 == 0) || items.every((e) => e[2] % 2 == 1)) {
    return [0, 2, 4, 6];
  } else {
    return [1, 3, 5, 7];
  }
};

const divide_one = (items) => {
  let tmp_m = 0;
  let tmp_s = 0;
  for (let i = 0; i < items.length; i++) {
    tmp_m += items[i][0];
    tmp_s += items[i][1];
  }
  tmp_m = Math.floor(tmp_m / 5);
  if (tmp_m <= 0) {
    return [];
  }
  tmp_s = Math.floor(tmp_s / items.length);
  const new_d = cal_d(items);
  const res = [];
  for (const d of new_d) {
    res.push([tmp_m, tmp_s, d]);
  }
  return res;
};

const divide_all = () => {
  const new_board = [...Array(N)].map(() => [...Array(N)].map(() => []));
  for (let yi = 0; yi < N; yi++) {
    for (let xi = 0; xi < N; xi++) {
      if (board[yi][xi].length >= 2) {
        const tmp_items = divide_one(board[yi][xi]);
        for (const [m, s, d] of tmp_items) {
          new_board[yi][xi].push([m, s, d]);
        }
      } else {
        new_board[yi][xi] = board[yi][xi];
      }
    }
  }
  return new_board;
};

const [N, M, K] = input().split(" ").map(Number);

let board = [...Array(N)].map(() => [...Array(N)].map(() => []));
const d_pos = [
  [-1, 0],
  [-1, 1],
  [0, 1],
  [1, 1],
  [1, 0],
  [1, -1],
  [0, -1],
  [-1, -1],
];

for (let i = 0; i < M; i++) {
  const [r, c, m, s, d] = input().split(" ").map(Number);
  board[r - 1][c - 1].push([m, s, d]);
}

for (let i = 0; i < K; i++) {
  board = move_all();
  board = divide_all();
}

let ans = 0;
for (let yi = 0; yi < N; yi++) {
  for (let xi = 0; xi < N; xi++) {
    for (const [m, ,] of board[yi][xi]) {
      ans += m;
    }
  }
}

console.log(ans);
