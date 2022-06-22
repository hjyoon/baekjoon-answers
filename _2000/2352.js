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
    if (arr[mid] < target) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }
  return right;
};

const N = Number(input());
const A = input().split(" ").map(Number);
const new_A = Array(N).fill(Infinity);
let ans = 0;

A.forEach((v) => {
  const pos = lower_bound(0, new_A.length, v, new_A);
  if (new_A[pos] == Infinity) {
    ans++;
  }
  new_A[pos] = v;
});

console.log(ans);
