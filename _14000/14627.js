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

const chk = (mid) => {
  let res = 0;
  for (const v of arr) {
    res += Math.floor(v / mid);
  }
  return res;
};

const [S, C] = input().split(" ").map(Number);
const arr = [];
for (let i = 0; i < S; i++) {
  arr.push(Number(input()));
}

let [left, right] = [1, 1000000000];
let mid;
let l = 0;
while (left <= right) {
  mid = Math.floor((left + right) / 2);
  const tmp = chk(mid);
  if (tmp >= C) {
    left = mid + 1;
    l = Math.max(l, mid);
  } else {
    right = mid - 1;
  }
}

let ans = arr.reduce((ac, v) => ac + v, 0) - l * C;
console.log(ans);
