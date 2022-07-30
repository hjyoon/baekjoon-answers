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

const [N, ...S] = stdin.map(Number);
S.sort((a, b) => a - b);
const cnts = [
  ...S.reduce((ac, v) => {
    // ac.has(v) ? ac.set(v, ac.get(v) + 1) : ac.set(v, 1);
    ac.set(v, (ac.get(v) || 0) + 1);
    return ac;
  }, new Map()),
].sort((a, b) => {
  if (b[1] == a[1]) {
    return a[0] - b[0];
  }
  return b[1] - a[1];
});

const ans = Array(4);

ans[0] = Math.round(S.reduce((ac, v) => ac + v, 0) / S.length).toString();
ans[1] = S[Math.floor(S.length / 2)];
if (cnts.length == 1) {
  ans[2] = cnts[0][0];
} else {
  if (cnts[0][1] != cnts[1][1]) {
    ans[2] = cnts[0][0];
  } else {
    ans[2] = cnts[1][0];
  }
}
ans[3] = Math.abs(S[S.length - 1] - S[0]);

console.log(ans.join("\n"));
