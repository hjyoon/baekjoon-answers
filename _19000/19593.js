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

const find = (node, parent) => {
  // path compression 기법
  if (parent.get(node) != node) {
    parent.set(node, find(parent.get(node), parent));
  }

  return parent.get(node);
};

const union = (v, u, parent, rank) => {
  const root1 = find(v, parent);
  const root2 = find(u, parent);

  // union-by-rank 기법
  if (rank.get(root1) > rank.get(root2)) {
    parent.set(root2, root1);
  } else {
    parent.set(root1, root2);
    if (rank.get(root1) == rank.get(root2)) {
      rank.set(root2, rank.get(root2) + 1);
    }
  }
};

const chk = (N, parent) => {
  const base = find(0, parent);
  for (let i = 0; i < N; i++) {
    if (find(i, parent) != base) {
      return false;
    }
  }
  return true;
};

let T = Number(input());
const ans = Array(T);
while (T--) {
  const [N, seed, A, B] = input().split(" ").map(Number);
  // const graph = [...Array(N)].map(() => []);
  const parent = new Map();
  for (let i = 0; i < N; i++) {
    parent.set(i, i);
  }
  const rank = new Map();
  for (let k of parent.keys()) {
    rank.set(k, 0);
  }
  const E = [seed % (N * N)];
  const E_set = new Set();
  const X = [Math.floor(E[0] / N)];
  const Y = [E[0] % N];
  let i = 0;
  while (1) {
    // console.log(parent);
    // const visited = [...Array(N)].fill(0);
    // graph[X[i]].push(Y[i]);
    // graph[Y[i]].push(X[i]);
    // dfs(graph, visited, 0);
    // if (chk(visited)) {
    //   break;
    // }
    union(X[i], Y[i], parent, rank);
    if (chk(N, parent)) {
      break;
    }
    i++;
    const tmp = (E[i - 1] * A + B) % (N * N);
    if (E_set.has(tmp)) {
      i = -1;
      break;
    }
    E.push(tmp);
    E_set.add(tmp);
    X.push(Math.floor(E[i] / N));
    Y.push(Math.floor(E[i] % N));
  }
  // console.log(parent, i + 1);
  ans[ans.length - T - 1] = i + 1;
}
console.log(ans.join("\n"));
