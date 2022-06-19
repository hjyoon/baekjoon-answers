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

const find = (node) => {
  // path compression 기법
  if (parent.get(node) != node) {
    parent.set(node, find(parent.get(node)));
  }

  return parent.get(node);
};

const union = (v, u) => {
  const root1 = find(v);
  const root2 = find(u);

  if (root1 == root2) {
    return S[root1];
  }

  // union-by-rank 기법
  if (rank.get(root1) > rank.get(root2)) {
    parent.set(root2, root1);
    S[root1] += S[root2];
    S[root2] = 0;
    return S[root1];
  } else {
    parent.set(root1, root2);
    S[root2] += S[root1];
    S[root1] = 0;
    if (rank.get(root1) == rank.get(root2)) {
      rank.set(root2, rank.get(root2) + 1);
    }
    return S[root2];
  }
};

const [N, M] = input().split(" ").map(Number);
const parent = new Map();
const rank = new Map();
const S = Array(N);
for (let i = 0; i < N; i++) {
  parent.set(i, i);
  rank.set(i, 0);
  S[i] = Number(input());
}

const ans = Array(M);
for (let i = 0; i < M; i++) {
  const [u, v] = input()
    .split(" ")
    .map((v) => Number(v) - 1);
  ans[i] = union(u, v);
}

console.log(ans.join("\n"));
