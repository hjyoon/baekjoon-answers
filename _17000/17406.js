"strict mode";
const assert = require("node:assert/strict");
const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const nextPerm = (s) => {
  let i = s.length - 2;
  let j = 0;

  while (i >= 0 && s[i] >= s[i + 1]) {
    i--;
  }

  if (i === -1) return null;
  else {
    j = i + 1;
    while (j < s.length && s[j] > s[i]) j++;
    [s[i], s[j - 1]] = [s[j - 1], s[i]];
  }

  return s.slice(undefined, i + 1).concat(s.slice(i + 1).reverse());
};

const copyArr = (arr) => {
  const ret = [];
  for (const v of arr) {
    ret.push([...v]);
  }
  return ret;
};

const calMin = (board) => {
  const ret = [];
  for (const v of board) {
    ret.push(v.reduce((v, ac) => ac + v, 0));
  }
  return Math.min(...ret);
};

const getPos = (start_y, start_x, len_y, len_x) => {
  const ret = [];
  const lens = [len_x, len_y, len_x, len_y];
  let cnt = lens[0] - 1;
  const dy = [1, 0, -1, 0];
  const dx = [0, 1, 0, -1];
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
  board[pos[0][0]][pos[0][1] + 1] = firstVal;
  return board;
};

const [N, M, K] = input().split(" ").map(Number);
const board = [...Array(N)].map(() => input().split(" ").map(Number));
const ops = [...Array(K)].map(() => input().split(" ").map(Number));
let ans = Infinity;

let s = [...Array(K)].map((v, i) => i);
while (s) {
  const tmp = copyArr(board);
  for (const i of s) {
    const [r, c, s] = ops[i];
    for (let i = 0; i < s; i++) {
      pos = getPos(
        r - s - 1 + i,
        c - s - 1 + i,
        (s - i) * 2 + 1,
        (s - i) * 2 + 1
      );
      rotatePos(pos, tmp);
    }
  }
  ans = Math.min(ans, calMin(tmp));
  // tmp.forEach((v) => console.error(...v));
  s = nextPerm(s);
}

console.log(ans);
