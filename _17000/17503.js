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

const [N, M, K] = input().split(" ").map(Number);
const A = Array(K);
for (let i = 0; i < K; i++) {
  A[i] = input().split(" ").map(Number);
}

// 도수가 특정 값보다 낮은 것 중에 선호도가 가장 높은거 N개를 골라야함

A.sort((a, b) => b[0] - a[0]);

const chk = (mid, n) => {
  let sum = 0;
  let cnt = 0;
  for (const [v, c] of A) {
    if (c <= mid) {
      sum += v;
      cnt++;
      if (cnt == n) {
        break;
      }
    }
  }
  return [sum, cnt];
};

let l = 1;
let r = 2147483647; // 2^21-1
let mid = Math.floor((l + r) / 2);
let ans = Infinity;
while (l <= r) {
  const [sum, cnt] = chk(mid, N);
  if (sum >= M && cnt == N) {
    r = mid - 1;
    ans = Math.min(ans, mid);
  } else {
    l = mid + 1;
  }
  mid = Math.floor((l + r) / 2);
}

console.log(ans == Infinity ? -1 : ans);
