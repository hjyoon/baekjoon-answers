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

const dfs = (pos, value) => {
  const intValue = Number(value);
  const tmp = Math.abs(N - intValue);
  if (tmp <= gap) {
    gap = tmp;
    if (tmp == Math.abs(N - lastValue) && intValue > lastValue) {
    } else {
      lastValue = intValue;
    }
  }
  for (let v = 0; v <= 9; v++) {
    if (pos == 0 && v == 0) {
      continue;
    }
    if (visited[v] == 0) {
      visited[v] = 1;
      dfs(pos + 1, value + v);
      visited[v] = 0;
    }
  }
};

let lastValue = Infinity;
let gap = Infinity;
const N = Number(input());
const visited = Array(10).fill(0);
dfs(0, "");
console.log(lastValue);
