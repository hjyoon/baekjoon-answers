const stdin = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'input.txt').toString().split('\n');
const input = (() => {
    let line = 0
    return () => stdin[line++].replace('\r', '')
})();

const [a, b, c] = input().split(' ').map(Number)
const n = Number(input())

let chk = [null].concat(new Array(a+b+c).fill(2))
let S = []
for(let i=0; i<n; i++) {
    const tmp = input().split(' ').map(Number)
    S.push(tmp)
}

S.sort((a, b) => b[3] - a[3])

for (const [i, j, k, r] of S) {
    if (r == 1) {
        chk[i] = chk[j] = chk[k] = 1
    }
    else {
        if (JSON.stringify([1, 1]) === JSON.stringify([chk[i], chk[j]])) {
            chk[k] = 0
        }
        else if (JSON.stringify([1, 1]) === JSON.stringify([chk[i], chk[k]])) {
            chk[j] = 0
        }
        else if (JSON.stringify([1, 1]) === JSON.stringify([chk[j], chk[k]])) {
            chk[i] = 0
        }
    }
}

console.log([...chk.slice(1)].join('\n'))