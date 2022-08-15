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

const get_divisor = (n) => {
  const divisors = [];
  const divisors_back = [];
  for (let i = 1; i <= Math.floor(n ** (1 / 2)); i++) {
    if (n % i == 0) {
      divisors.push(i);
      if (i == Math.floor(n / i)) continue;
      divisors_back.push(Math.floor(n / i));
    }
  }
  return divisors.concat(divisors_back.reverse());
};

const [N, K] = input().split(" ").map(Number);
const divisors = get_divisor(N);
console.log(divisors.length < K ? 0 : divisors[K - 1]);
