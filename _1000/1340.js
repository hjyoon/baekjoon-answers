// // let fs = require('fs');

// // 한 줄 입력
// // let input = fs.readFileSync('/dev/stdin').toString().split(' ');
// //let input = fs.readFileSync('input.txt').toString().split(' ');

// // 여러 줄 입력
// //let input = fs.readFileSync('/dev/stdin').toString().split('\n');
// // let input = fs.readFileSync('input.txt').toString().split('\r\n');

// const stdin = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'input.txt').toString().split('\n');

// const input = (() => {
//     let line = 0
//     return () => stdin[line++].replace('\r', '')
// })();


// //let num = Number(input);
// console.log(input().length);

// // for (let i = 1; i <= num; i++) {
// //     console.log(i);
// // }

const stdin = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'input.txt').toString().split('\n');

const input = (() => {
    let line = 0
    return () => stdin[line++].replace('\r', '')
})();

const a = input()
const b = input()

console.log(new Array(a));
console.log(new Array(b));

console.log(a * b[2]);
console.log(a * b[1]);
console.log(a * b[0]);
console.log(a * b);