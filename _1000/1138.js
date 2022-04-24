const stdin = require("fs").readFileSync("/dev/stdin").toString().split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const N = Number(input());
const S = input().split(" ").map(Number);

const res = [...Array(N)].fill(0);

for (let i = 1; i <= N; i++) {
  let cnt = S[i - 1];
  let idx = 0;
  while (true) {
    if (res[idx] == 0) {
      if (cnt == 0) {
        res[idx] = i;
        break;
      } else {
        cnt--;
      }
    }
    idx++;
  }
}

console.log(...res);
