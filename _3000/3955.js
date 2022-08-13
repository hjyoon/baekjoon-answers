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

const extended_gcd = (a, b) => {
  let [x, y, u, v] = [0, 1, 1, 0];
  while (a !== 0) {
    const [q, r] = [Math.floor(b / a), b % a];
    const [m, n] = [x - u * q, y - v * q];
    [b, a, x, y, u, v] = [a, r, u, v, m, n];
  }
  const gcd = b;
  return [gcd, x, y];
};

let T = Number(input());
while (T--) {
  const [K, C] = input().split(" ").map(Number);
  const [gcd, x, y] = extended_gcd(K, C);
  if (gcd !== 1) {
    console.log("IMPOSSIBLE");
    continue;
  }
  let ans = (y + K) % K;
  while (C * ans <= K) ans += K;
  if (ans > 1000000000) {
    console.log("IMPOSSIBLE");
    continue;
  }
  console.log(ans);
}
