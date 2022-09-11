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

const rangeSum = (start, end, ac) => {
  return ac[end] - ac[start - 1];
};

const [N, K, Q, M] = input().split(" ").map(Number);
const dozed = input().split(" ").map(Number);
const received = input().split(" ").map(Number);
const ranges = [...Array(M)].map(() => input().split(" ").map(Number));

const students = [0, 0, 0, ...Array(N).fill(1)];
for (const s of dozed) {
  students[s] = -1;
}
for (const s of received) {
  if (students[s] === -1) continue;
  for (let i = s; i < students.length; i += s) {
    if (students[i] === -1) continue;
    students[i] = 0;
  }
}

const ac = Array(N + 3).fill(0);
for (let i = 3; i < ac.length; i++) {
  if ([-1, 1].includes(students[i])) ac[i] = ac[i - 1] + 1;
  else ac[i] = ac[i - 1];
}

console.log(ranges.map((v) => rangeSum(v[0], v[1], ac)).join("\n"));
