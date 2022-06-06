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
const arr = Array(100000);
for (let i = 0; i < N; i++) {
  const [s, e] = input().split(" ").map(Number);
  arr[i] = [s, e];
}

let ans = Infinity;
let ans_arr = Array(100000);
let res_arr = Array(100000);
for (let j = arr[0][0]; j <= arr[0][1]; j++) {
  let pos = j;
  let res = 0;
  for (let i = 0; i < N; i++) {
    const [cur_s, cur_e] = arr[i];
    if (cur_s <= pos && pos <= cur_e) {
    } else if (pos > cur_e) {
      res += pos - cur_e;
      pos = cur_e;
    } else if (pos < cur_s) {
      res += cur_s - pos;
      pos = cur_s;
    }
    res_arr[i] = pos;
  }
  if (res < ans) {
    ans = res;
    [ans_arr, res_arr] = [res_arr, ans_arr];
  }
}

console.log(ans);
for (let i = 0; i < N; i++) {
  console.log(ans_arr[i]);
}
