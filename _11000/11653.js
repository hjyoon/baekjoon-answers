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

const factorize = (n) => {
  const helper = (m) => {
    // m은 항상 2이상의 소수라고 가정
    if (m === 2) return 3;
    if (m === 3) return 5;
    let k = m % 6 === 5 ? m : m - 2;
    const l = Math.floor(n ** 0.5);
    while (k <= l) {
      if (n % k === 0) return k;
      if (n % (k + 2) === 0) return k + 2;
      k += 6;
    }
    return n;
  };

  const ret = [];
  let [a, b] = [2, 0];
  while (n > 1) {
    while (n % a == 0) {
      n = Math.floor(n / a);
      b++;
    }
    if (b > 0) {
      ret.push([a, b]);
      b = 0;
    }
    a = helper(a);
  }
  return ret;
};

const N = Number(input());
const l = factorize(N);
const ans = [];
for (const [a, b] of l) {
  ans.push(...Array(b).fill(a));
}
console.log(ans.join("\n"));
