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
const buf = [["", 0]];
for (let i = 0; i < N; i++) {
  const [op, value, t] = input().split(" ");
  if (op == "type") {
    buf.push([buf[buf.length - 1][0] + value, t]);
  } else {
    let j = i;
    while (buf[j][1] > t - value - 1 && j > 0) {
      j--;
    }
    buf.push([buf[j][0], t]);
  }
}

console.log(buf[buf.length - 1][0]);
