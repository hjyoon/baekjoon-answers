"strict mode";
const assert = require("node:assert/strict");
const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const [_D, _N] = input().split(" ").map(Number);
const diametersOven = [undefined, ...input().split(" ").map(Number)];
const diametersPizzaDough = input().split(" ").map(Number);

for (let i = 1; i < diametersOven.length; i++) {
  if (diametersOven[i] > diametersOven[i - 1]) {
    diametersOven[i] = diametersOven[i - 1];
  }
}

let [iOven, iPizzaDough] = [diametersOven.length - 1, 0];
while (1) {
  if (diametersPizzaDough[iPizzaDough] <= diametersOven[iOven]) iPizzaDough++;
  if (iPizzaDough >= diametersPizzaDough.length) break;
  if (--iOven <= 0) break;
}

console.log(iOven);
