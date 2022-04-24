const stdin = require('fs').readFileSync(process.platform==='linux'?'/dev/stdin':'input.txt').toString().split('\n');

const input = (() => {
    let line = 0
    return () => stdin[line++]
})();

const a = input()
const b = input()

console.log(a*b[2]);
console.log(a*b[1]);
console.log(a*b[0]);
console.log(a*b);