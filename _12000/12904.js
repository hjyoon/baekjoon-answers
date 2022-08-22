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

const compare = (arr_A, arr_B) => {
  if (arr_A.length != arr_B.length) return false;
  for (let i = 0; i < arr_A.length; i++) {
    if (arr_A[i] != arr_B[i]) return false;
  }
  return true;
};

const S = input().split("");
let T = input().split("");

while (S.length < T.length) {
  T.pop();
  if (T[T.length - 1] == "B") {
    T.reverse();
  }
}

console.log(compare(S, T) ? 1 : 0);
