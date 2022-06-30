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

const dfs = (pos, depth) => {
  if (visit[pos] == -1) {
    return;
  }
  if (visit[pos]) {
    const tmp = buf.slice(visit[pos] - 1, buf.length);
    ans.push(...tmp.map((v) => v + 1));
    return;
  }
  visit[pos] = depth;
  buf.push(pos);
  dfs(A[pos], depth + 1);
  visit[pos] = -1;
};

const N = Number(input());
const A = Array(N);
const visit = Array(N).fill(0);
const buf = [];
let ans = [];
for (let i = 0; i < N; i++) {
  A[i] = Number(input()) - 1;
}

for (let i = 0; i < N; i++) {
  dfs(i, 1);
  buf.length = 0;
}

ans.sort((a, b) => a - b);
console.log(ans.length);
console.log(ans.join("\n"));
