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

while (1) {
  const L = input();
  if (!L) break; // undefined
  const [N, S] = L.split(" ").map(Number);
  console.log(Math.floor(S / (N + 1)));
}
