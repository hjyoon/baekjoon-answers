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

const toComputable = (arr) => {
  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      arr[i][j] = arr[i][j] === "." ? 0 : 1;
    }
  }
  return arr;
};

const compareBoard = (board_A, board_B) => {
  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      if (board_A[i][j] != board_B[i][j]) {
        return false;
      }
    }
  }
  return true;
};

const copyBoard = (src_board) => {
  const dst_board = [];
  for (const v of src_board) {
    dst_board.push([...v]);
  }
  return dst_board;
};

const solution = (board, bit_limit) => {
  if (
    compareBoard(board, [
      [0, 0, 0],
      [0, 0, 0],
      [0, 0, 0],
    ])
  ) {
    return 0;
  }
  let ret = Infinity;
  for (let i = 0; i < 2 ** bit_limit; i++) {
    const tmp_board = copyBoard(board);
    const pos = checkBit(i, bit_limit);
    for (const [y, x] of pos) {
      reverse_cross(tmp_board, y, x);
      if (
        compareBoard(tmp_board, [
          [0, 0, 0],
          [0, 0, 0],
          [0, 0, 0],
        ])
      ) {
        ret = Math.min(ret, pos.length);
      }
    }
  }
  return ret;
};

const checkBit = (n, bit_limit) => {
  const ret = [];
  for (let i = 0; i < bit_limit; i++) {
    if (n & (1 << i)) {
      ret.push([Math.floor(i / 3), i % 3]);
    }
  }
  return ret;
};

const reverse_cross = (board, y, x) => {
  const d_pos = [
    [0, 0],
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];
  for (let i = 0; i < d_pos.length; i++) {
    if (
      y + d_pos[i][0] < 0 ||
      y + d_pos[i][0] >= 3 ||
      x + d_pos[i][1] < 0 ||
      x + d_pos[i][1] >= 3
    )
      continue;
    board[y + d_pos[i][0]][x + d_pos[i][1]] =
      board[y + d_pos[i][0]][x + d_pos[i][1]] === 0 ? 1 : 0;
  }
  return board;
};

let T = Number(input());
while (T--) {
  const board = toComputable([...Array(3)].map(() => input().split("")));
  console.log(solution(board, 9));
}

const test_board = [
  [0, 0, 0],
  [0, 0, 0],
  [0, 0, 0],
];

assert.deepStrictEqual(solution(test_board, 9), 0);
assert.deepStrictEqual(solution(test_board, 9), 0);

assert.deepStrictEqual(
  toComputable([
    ["*", "*", "."],
    ["*", ".", "."],
    [".", ".", "."],
  ]),
  [
    [1, 1, 0],
    [1, 0, 0],
    [0, 0, 0],
  ]
);

assert.deepStrictEqual(
  toComputable([
    ["*", "*", "*"],
    ["*", ".", "."],
    [".", ".", "*"],
  ]),
  [
    [1, 1, 1],
    [1, 0, 0],
    [0, 0, 1],
  ]
);

assert.deepStrictEqual(
  reverse_cross(
    [
      [0, 0, 0],
      [0, 0, 0],
      [0, 0, 0],
    ],
    0,
    0
  ),
  [
    [1, 1, 0],
    [1, 0, 0],
    [0, 0, 0],
  ]
);

assert.deepStrictEqual(
  compareBoard(
    [
      [0, 0, 0],
      [0, 0, 0],
      [0, 0, 0],
    ],
    [
      [0, 0, 0],
      [0, 0, 0],
      [0, 0, 0],
    ]
  ),
  true
);

assert.deepStrictEqual(
  compareBoard(
    [
      [0, 0, 0],
      [0, 0, 0],
      [0, 0, 0],
    ],
    [
      [1, 1, 0],
      [1, 0, 0],
      [0, 0, 0],
    ]
  ),
  false
);

assert.deepStrictEqual(checkBit(9, 9), [
  [0, 0],
  [1, 0],
]);
assert.deepStrictEqual(checkBit(18, 9), [
  [0, 1],
  [1, 1],
]);
assert.deepStrictEqual(checkBit(8, 9), [[1, 0]]);
assert.deepStrictEqual(checkBit(0, 9), []);
assert.deepStrictEqual(checkBit(256, 9), [[2, 2]]);
assert.deepStrictEqual(checkBit(512, 9), []);

assert.strictEqual(
  solution(
    [
      [0, 1, 0],
      [1, 1, 1],
      [0, 1, 0],
    ],
    9
  ),
  1
);

assert.strictEqual(
  solution(
    [
      [1, 1, 0],
      [1, 0, 1],
      [0, 1, 1],
    ],
    9
  ),
  2
);

assert.strictEqual(
  solution(
    [
      [1, 0, 0],
      [0, 1, 0],
      [0, 0, 1],
    ],
    9
  ),
  3
);

assert.strictEqual(
  solution(
    [
      [1, 1, 1],
      [1, 0, 0],
      [0, 0, 1],
    ],
    9
  ),
  3
);

assert.strictEqual(
  solution(
    [
      [0, 0, 0],
      [0, 0, 0],
      [0, 0, 0],
    ],
    9
  ),
  0
);
