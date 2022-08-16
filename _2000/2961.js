"strict mode";
const assert = require("node:assert/strict");
const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

function* subset(bitSize) {
  for (let v = 1; v < 2 ** bitSize; v++) {
    const ret = [];
    for (let i = 0; i < bitSize; i++) {
      if (v & (1 << i)) {
        ret.push(i);
      }
    }
    yield ret;
  }
}

const N = Number(input());
const ingredients = [...Array(N)].map(() => input().split(" ").map(Number));
let ans = Infinity;

for (const v of subset(N)) {
  const pickedIngredients = v.map((i) => ingredients[i]);
  const [sourness, bitterness] = pickedIngredients.reduce(
    (result, row) => row.map((_, i) => [...(result[i] || []), row[i]]),
    []
  );
  const totalSour = sourness.reduce((ac, v) => ac * v, 1);
  const totalBitter = bitterness.reduce((ac, v) => ac + v, 0);
  ans = Math.min(ans, Math.abs(totalSour - totalBitter));
}

console.log(ans);
