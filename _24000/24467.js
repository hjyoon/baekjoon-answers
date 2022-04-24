const stdin = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const rule = [5, 1, 2, 3, 4];
const move_list = stdin
  .map((v) => [...v])
  .filter((v) => v.length > 0)
  .map((v) => v.filter((v) => v == "0"))
  .map((v) => v.length)
  .map((v) => rule[v]);

let top_right = false;
let goal = 21;
let cur = 0;
let ans = "LOSE";

move_list.some((e) => {
  cur += e;
  if (!top_right && cur == 5) {
    top_right = true;
    goal = 17;
  } else if (top_right && cur == 8) {
    goal = 12;
  } else if (!top_right && cur == 10) {
    goal = 17;
  }
  if (cur >= goal) {
    ans = "WIN";
    return true;
  }
  return false;
});

console.log(ans);
