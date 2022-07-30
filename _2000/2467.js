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

const N = Number(input());
const A = input().split(" ").map(Number);
let [left, right] = [0, N - 1];

let [ans_left, ans_right, min_hap] = [undefined, undefined, Infinity];

while (left < right) {
  const [tmp_left, tmp_right] = [Math.abs(A[left]), Math.abs(A[right])];
  const tmp_hap = Math.abs(A[left] + A[right]);

  if (tmp_hap < min_hap) {
    [ans_left, ans_right, min_hap] = [left, right, tmp_hap];
  }

  if (tmp_left < tmp_right) {
    right--;
  } else if (tmp_left > tmp_right) {
    left++;
  } else {
    right--;
    left++;
  }
}

console.log(A[ans_left], A[ans_right]);
