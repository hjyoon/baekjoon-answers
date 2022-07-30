"strict mode";

const { exit } = require("process");

const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const S = input();
const st = [];
let ans = 0;
for (let i = 0; i < S.length; i++) {
  switch (S[i]) {
    case "q":
      st.push(1);
      break;
    case "u":
      if (!st.length) {
        console.log(-1);
        exit();
      }
      for (let j = 0; j < st.length; j++) {
        if (st[j] == 1) {
          st[j]++;
          break;
        }
        if (j == st.length - 1) {
          console.log(-1);
          exit();
        }
      }
      break;
    case "a":
      if (!st.length) {
        console.log(-1);
        exit();
      }
      for (let j = 0; j < st.length; j++) {
        if (st[j] == 2) {
          st[j]++;
          break;
        }
        if (j == st.length - 1) {
          console.log(-1);
          exit();
        }
      }
      break;
    case "c":
      if (!st.length) {
        console.log(-1);
        exit();
      }
      for (let j = 0; j < st.length; j++) {
        if (st[j] == 3) {
          st[j]++;
          break;
        }
        if (j == st.length - 1) {
          console.log(-1);
          exit();
        }
      }
      break;
    case "k":
      if (!st.length) {
        console.log(-1);
        exit();
      }
      for (let j = 0; j < st.length; j++) {
        if (st[j] == 4) {
          st.shift();
          break;
        }
        if (j == st.length - 1) {
          console.log(-1);
          exit();
        }
      }
      break;
  }
  ans = Math.max(ans, st.length);
}

console.log(st.length ? -1 : ans);
