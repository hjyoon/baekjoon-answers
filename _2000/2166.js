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

// 벡터의 외적
const ccw = (x1, y1, x2, y2, x3, y3) => {
  const first = (x2 - x1) * (y3 - y1);
  const second = (y2 - y1) * (x3 - x1);
  return first - second;
};

const N = Number(input());
const points = Array(N);
for (let i = 0; i < N; i++) {
  points[i] = input().split(" ").map(Number);
}

const [standard_x, standard_y] = points[0];
let ans = 0;

for (let i = 1; i < N - 1; i++) {
  ans += ccw(
    standard_x,
    standard_y,
    points[i][0],
    points[i][1],
    points[i + 1][0],
    points[i + 1][1]
  );
}

ans = Math.abs(ans) / 2;
console.log(ans.toFixed(1));
