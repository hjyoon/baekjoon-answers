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

const toMinute = (s) => {
  const [hour, minute] = [s.slice(0, 2), s.slice(2, 4)].map(Number);
  return (hour - 10) * 60 + minute;
};

const N = Number(input());
const times = [];
let ans = 0;

times.push([0, 0]);
for (let i = 0; i < N; i++) {
  const [start, end] = input().split(" ").map(toMinute);
  times.push([Math.max(start - 10, 0), Math.min(end + 10, 720)]);
}
times.push([720, 720]);

times.sort((a, b) => {
  if (a[1] == b[1]) {
    return a[0] - b[0];
  }
  return a[1] - b[1];
});

for (let i = 0; i < times.length - 1; i++) {
  ans = Math.max(ans, times[i + 1][0] - times[i][1]);
}

console.log(Math.max(ans, 0));
