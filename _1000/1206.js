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
const S = new Set();
for (let i = 0; i < N; i++) {
  const tmp = Number(`0.${input().split(".")[1]}`);
  S.add(tmp);
}
const S_arr = [...S];

let j = 1;
while (1) {
  const tmp = new Set();
  for (let i = 0; i <= j; i++) {
    tmp.add(Math.floor((i / j) * 1000) / 1000);
  }
  const intersection = new Set(S_arr.filter((x) => tmp.has(x)));
  if (intersection.size == S_arr.length) break;
  j++;
}

console.log(j);
