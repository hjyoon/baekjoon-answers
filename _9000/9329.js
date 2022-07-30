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

const chk = (k_arr, m_arr) => {
  let min = Infinity;
  for (const v of k_arr) {
    if (m_arr[v - 1] < min) {
      min = m_arr[v - 1];
    }
  }
  return min;
};

let T = Number(input());
while (T--) {
  const [n, m] = input().split(" ").map(Number);
  const tmp = [];
  for (let i = 0; i < n; i++) {
    const [k, ...rest] = input().split(" ").map(Number);
    const k_arr = rest.splice(0, k);
    const reward = rest[rest.length - 1];
    tmp.push([k_arr, reward]);
  }
  const m_arr = input().split(" ").map(Number);

  let res = 0;
  for (const [k_arr, reward] of tmp) {
    const times = chk(k_arr, m_arr);
    for (const v of k_arr) {
      m_arr[v - 1] -= times;
    }
    res += reward * times;
  }
  console.log(res);
}
