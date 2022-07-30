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

const dfs = (pos, graph, visit) => {
  if (visit[pos]) return;
  visit[pos] = 1;
  for (const next of graph[pos]) {
    dfs(next, graph, visit);
  }
};

let T = Number(input());
while (T--) {
  const N = Number(input());
  const point = Array(N + 2);
  for (let i = 0; i < N + 2; i++) {
    point[i] = input().split(" ").map(Number);
  }
  const graph = [...Array(N + 2)].map(() => []);
  for (let i = 0; i < N + 2; i++) {
    for (let j = i + 1; j < N + 2; j++) {
      const dist_y = Math.abs(point[i][0] - point[j][0]);
      const dist_x = Math.abs(point[i][1] - point[j][1]);
      if (dist_y + dist_x <= 1000) {
        graph[i].push(j);
        graph[j].push(i);
      }
    }
  }
  const visit = Array(N + 2).fill(0);
  dfs(0, graph, visit);
  console.log(visit[N + 1] == 1 ? "happy" : "sad");
}
