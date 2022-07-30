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

const blocks = [
  // oooo
  [
    [0, 0],
    [0, 1],
    [0, 2],
    [0, 3],
  ],

  // o
  // o
  // o
  // o
  [
    [0, 0],
    [1, 0],
    [2, 0],
    [3, 0],
  ],

  // oo
  // oo
  [
    [0, 0],
    [1, 0],
    [0, 1],
    [1, 1],
  ],

  // oo
  //  oo
  [
    [0, 0],
    [0, 1],
    [1, 1],
    [1, 2],
  ],

  //  o
  // oo
  // o
  [
    [0, 1],
    [1, 1],
    [1, 0],
    [2, 0],
  ],

  // ooo
  //   o
  [
    [0, 0],
    [0, 1],
    [0, 2],
    [1, 2],
  ],

  // o
  // ooo
  [
    [0, 0],
    [1, 0],
    [1, 1],
    [1, 2],
  ],

  //  o
  //  o
  // oo
  [
    [0, 1],
    [1, 1],
    [2, 1],
    [2, 0],
  ],

  // oo
  // o
  // o
  [
    [0, 0],
    [0, 1],
    [1, 0],
    [2, 0],
  ],

  // ooo
  //  o
  [
    [0, 0],
    [0, 1],
    [0, 2],
    [1, 1],
  ],

  //  o
  // ooo
  [
    [0, 1],
    [1, 0],
    [1, 1],
    [1, 2],
  ],

  // o
  // oo
  // o
  [
    [0, 0],
    [1, 0],
    [2, 0],
    [1, 1],
  ],

  //  o
  // oo
  //  o
  [
    [0, 1],
    [1, 0],
    [1, 1],
    [2, 1],
  ],
];

const check = (A, block, start_y, start_x) => {
  let res = 0;
  for (const [dy, dx] of block) {
    if (start_y + dy >= A.length || start_x + dx >= A.length) {
      return -Infinity;
    }
    res += A[start_y + dy][start_x + dx];
  }
  return res;
};

let T = 0;
while (1) {
  T++;
  const N = Number(input());
  if (N == 0) {
    break;
  }
  const A = [...Array(N)].map(() => input().trim().split(/ +/).map(Number));
  let ans = -Infinity;

  for (let k = 0; k < blocks.length; k++) {
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < N; j++) {
        const tmp = check(A, blocks[k], i, j);
        ans = Math.max(ans, tmp);
      }
    }
  }

  console.log(`${T}. ${ans}`);
}
