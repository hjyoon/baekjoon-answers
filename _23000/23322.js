const stdin = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [N, K] = stdin[0].split(" ").map(Number);
const A = stdin[1].split(" ").map(Number);

const min = A[0];
const date = A.filter((v) => v != min).length;
const num = A.reduce((a, v) => a + v) - min * A.length;

console.log(num, date);
