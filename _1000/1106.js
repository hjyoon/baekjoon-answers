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

const dfs = async (people, price) => {
  console.error(idx, people, price);
  if (idx >= N) {
    return;
  }
  if (price >= ans) {
    idx++;
    return;
  }
  if (people >= C) {
    ans = Math.min(ans, price);
    idx++;
    return;
  }
  while (idx < N) {
    dfs(people + cities[idx][1], price + cities[idx][0]);
  }
};

const [C, N] = input().split(" ").map(Number);
const cities = [...Array(N)].map(() => input().split(" ").map(Number));
let idx = 0;
let ans = Infinity;
cities.sort((a, b) => b[1] / b[0] - a[1] / a[0]); // 효율이 높은게 앞으로 오게 정렬

// console.log(cities);
// console.log(cities[idx][1], cities[idx][0]);

dfs(cities[idx][1], cities[idx][0]);

console.log(ans);
