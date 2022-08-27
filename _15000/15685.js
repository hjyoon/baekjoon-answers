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

const dy = [0, -1, 0, 1];
const dx = [1, 0, -1, 0];
const board = [...Array(101)].map(() => Array(101).fill(0));

const rec = (start_y, start_x, d, g) => {
  if (g == 0) {
    board[start_y][start_x] = 1;
    board[start_y + dy[d]][start_x + dx[d]] = 1;
    return [start_y + dy[d], start_x + dx[d], [d]];
  }
  const [dst_y, dst_x, trace] = rec(start_y, start_x, d, g - 1);
  const [dst_rot_y, dst_rot_x, trace_rot] = rec_rot_90(dst_y, dst_x, trace);
  return [dst_rot_y, dst_rot_x, [...trace, ...trace_rot]];
};

const rec_rot_90 = (start_y, start_x, trace) => {
  const new_trace = [];
  let [tmp_y, tmp_x] = [start_y, start_x];
  for (let i = trace.length - 1; i >= 0; i--) {
    const d = (trace[i] + 1) % 4;
    new_trace.push(d);
    [tmp_y, tmp_x] = [tmp_y + dy[d], tmp_x + dx[d]];
    board[tmp_y][tmp_x] = 1;
  }
  return [tmp_y, tmp_x, new_trace];
};

const N = Number(input());
for (let i = 0; i < N; i++) {
  const [x, y, d, g] = input().split(" ").map(Number);
  rec(y, x, d, g);
}

let ans = 0;
for (let i = 0; i < 100; i++) {
  for (let j = 0; j < 100; j++) {
    ans += [
      [i, j],
      [i, j + 1],
      [i + 1, j],
      [i + 1, j + 1],
    ].every(([y, x]) => board[y][x]);
  }
}

console.log(ans);
