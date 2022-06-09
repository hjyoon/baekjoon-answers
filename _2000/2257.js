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

const rec = (i) => {
  let pos = i;
  let sum = 0;
  while (pos < S.length) {
    if (S[pos] == "H") {
      if (
        pos + 1 < S.length &&
        [2, 3, 4, 5, 6, 7, 8, 9].includes(Number(S[pos + 1]))
      ) {
        sum += Number(S[pos + 1]);
        pos += 2;
      } else {
        sum += 1;
        pos += 1;
      }
    } else if (S[pos] == "C") {
      if (
        pos + 1 < S.length &&
        [2, 3, 4, 5, 6, 7, 8, 9].includes(Number(S[pos + 1]))
      ) {
        sum += 12 * Number(S[pos + 1]);
        pos += 2;
      } else {
        sum += 12;
        pos += 1;
      }
    } else if (S[pos] == "O") {
      if (
        pos + 1 < S.length &&
        [2, 3, 4, 5, 6, 7, 8, 9].includes(Number(S[pos + 1]))
      ) {
        sum += 16 * Number(S[pos + 1]);
        pos += 2;
      } else {
        sum += 16;
        pos += 1;
      }
    } else if (S[pos] == "(") {
      [added_sum, new_pos] = rec(pos + 1);
      sum += added_sum;
      pos = new_pos;
    } else if (S[pos] == ")") {
      if (
        pos + 1 < S.length &&
        [2, 3, 4, 5, 6, 7, 8, 9].includes(Number(S[pos + 1]))
      ) {
        sum *= Number(S[pos + 1]);
        pos += 2;
        break;
      } else {
        pos += 1;
        break;
      }
    }
  }
  return [sum, pos];
};

const S = input();
console.log(rec(0)[0]);
