"strict mode";
const [_, ...A] = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split(/\s/);

console.log(
  A.map((v) => {
    v = parseInt(v, 16);
    if (0x10 <= v && v <= 0x1f) {
      return ".";
    } else {
      return "-";
    }
  }).join("")
);

const range = (start, stop, step) =>
  Array.from({ length: (stop - start) / step + 1 }, (_, i) => start + i * step);
