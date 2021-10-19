"use strict"
const stdin = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'input.txt').toString().split('\n');
const input = (() => {
    let line = 0
    return () => stdin[line++]
})();

const t1_score = input().split(' ').map(Number)
const t2_score = input().split(' ').map(Number)

let [t1_ac, t2_ac] = [0, 0]

let sw = 0
for (let i = 0; i < 9; i++) {
    t1_ac += t1_score[i]
    if (t1_ac > t2_ac) {
        sw = 1
        break
    }
    t2_ac += t2_score[i]
}

console.log(['No', 'Yes'][sw])