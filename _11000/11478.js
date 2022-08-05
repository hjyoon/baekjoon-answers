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

const dfs = (start, end) => {
  if (start >= S.length || end >= S.length) return;
  if (visit.has(`${start} ${end}`)) return;
  visit.add(`${start} ${end}`);
  data.add(S.slice(start, end + 1));
  dfs(start + 1, end + 1);
  dfs(start, end + 1);
};

const S = input();
const data = new Set();
const visit = new Set();
dfs(0, 0);
console.log(data.size);
