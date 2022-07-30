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

const lower_bound = (left, right, target, arr) => {
  while (left < right) {
    const mid = Math.floor((left + right) / 2);
    if (arr[mid][1] < target[1]) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }
  return right;
};

const N = Number(input());
const A = Array(N);
for (let i = 0; i < N; i++) {
  const tmp = input().split(" ").map(Number);
  A[i] = tmp;
}
A.sort((a, b) => a[0] - b[0]);

const B = Array(N).fill([Infinity, Infinity]);
const track = Array(N);
const chk = Array(N).fill(0);
const ans = [];
let target = 0;

A.forEach((v, i) => {
  const pos = lower_bound(0, B.length, v, B);
  if (B[pos][0] == Infinity) {
    target++;
  }
  track[i] = pos;
  B[pos] = v;
});

for (let i = track.length - 1; i >= 0; i--) {
  if (target == 0) {
    break;
  }
  if (track[i] == target - 1) {
    chk[i] = 1;
    target--;
  }
}

chk.forEach((v, i) => {
  if (v == 0) {
    ans.push(A[i][0]);
  }
});

console.log(ans.length);
console.log(ans.join("\n"));
