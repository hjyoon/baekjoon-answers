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
  const [nx, ny, w] = input().split(" ").map(Number);
  if (nx == 0 && ny == 0 && w == 0) {
    break;
  }
  const xi = input()
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);
  const yi = input()
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);

  let base = 0;
  for (const v of xi) {
    if (v - w / 2 > base) {
      break;
    }
    base = v + w / 2;
  }

  if (base < 75) {
    console.log("NO");
    continue;
  }

  base = 0;
  for (const v of yi) {
    if (v - w / 2 > base) {
      break;
    }
    base = v + w / 2;
  }

  if (base < 100) {
    console.log("NO");
    continue;
  }

  console.log("YES");
}
