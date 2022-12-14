"strict mode";
const stdin = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const n = Number(input());
let t = Number(input());
const b = Number(input());

let c = 4;
let res = 0;

while (1) {
  if (t - c <= 0) break;
  t -= c;
  res += c * 2;
  c++;
}

if (b === 0) {
  if (t === 1) {
    res += 1;
  } else if (t === 2) {
    res += 3;
  } else {
    res += t + 2;
  }
} else if (b === 1) {
  if (t === 1) {
    res += 2;
  } else if (t === 2) {
    res += 4;
  } else {
    res += t + c;
  }
}

console.log((res - 1) % n);
