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

const getPos = (start_y, start_x, len_y, len_x) => {
  const ret = [];
  const lens = [len_x, len_y, len_x, len_y];
  let cnt = lens[0] - 1;
  const dy = [0, 1, 0, -1];
  const dx = [1, 0, -1, 0];
  let i = 0;
  ret.push([start_y, start_x]);

  while (i < dy.length) {
    start_y += dy[i];
    start_x += dx[i];
    ret.push([start_y, start_x]);
    cnt--;
    if (cnt == 0) {
      i++;
      cnt = lens[i] - 1;
    }
  }
  return ret;
};

const rotatePos = (pos, board) => {
  const firstVal = board[pos[0][0]][pos[0][1]];
  for (let i = 0; i < pos.length - 1; i++) {
    board[pos[i][0]][pos[i][1]] = board[pos[i + 1][0]][pos[i + 1][1]];
  }
  board[pos[0][0] + 1][pos[0][1]] = firstVal;
};

const [N, M, R] = input().split(" ").map(Number);
const board = [...Array(N)].map(() => input().split(" ").map(Number));
const pos = [];

for (let i = 0; i < Math.min(N, M) / 2; i++) {
  pos.push(getPos(i, i, N - i * 2, M - i * 2));
}

for (let i = 0; i < R; i++) {
  for (const v of pos) {
    rotatePos(v, board);
  }
}

let ans = "";
for (const v of board) {
  ans += v.join(" ") + "\n";
}
console.log(ans);
