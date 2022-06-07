"strict mode";
const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split("\n");

const N = Number(stdin[0]);
const arr = Array(100000);
for (let i = 0; i < N; i++) {
  arr[i] = stdin[i + 1].split(" ").map(Number);
}

let ans = Infinity;
let ans_arr = Array(100000);
let res_arr = Array(100000);
for (let j = arr[0][0]; j <= arr[0][1]; j++) {
  let pos = j;
  let res = 0;
  for (let i = 0; i < N; i++) {
    if (pos > arr[i][1]) {
      res += pos - arr[i][1];
      pos = arr[i][1];
    } else if (pos < arr[i][0]) {
      res += arr[i][0] - pos;
      pos = arr[i][0];
    }
    if (res >= ans) {
      break;
    }
    res_arr[i] = pos;
  }
  if (res < ans) {
    ans = res;
    [ans_arr, res_arr] = [res_arr, ans_arr];
  }
}

console.log(ans);
console.log(ans_arr.join("\n"));
