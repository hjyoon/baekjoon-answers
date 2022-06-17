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
const graph = new Map();
const visited = [...Array(N)].fill(0);
for (let i = 0; i < N - 1; i++) {
  const n = Number(input());
  if (n == 0) {
    input();
    graph.set(i, []);
    continue;
  }
  const a = input()
    .split(" ")
    .map((v) => Number(v) - 1);
  graph.set(i, a);
}
graph.set(N - 1, []);

const dfs = (root) => {
  if (visited[root] == 1) {
    return true;
  }
  visited[root] = 1;

  for (let i of graph.get(root)) {
    const res = dfs(i);
    if (res == true) {
      return res;
    }
  }
  visited[root] = 0;
  return false;
};

console.log(dfs(0) ? "CYCLE" : "NO CYCLE");
