const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const K = Number(input());
const e = Math.log2(K);
const ceiled_e = Math.ceil(e);

if (Number.isInteger(e)) {
  console.log(2 ** ceiled_e, 0);
} else {
  console.log(2 ** ceiled_e, K.toString(2).lastIndexOf("1") + 1);
}
