"use strict"
const stdin = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'input.txt').toString().split('\n');
const input = (() => {
    let line = 0
    return () => stdin[line++]
})();

const N = Number(input())
const S = [null,]
for (let i = 0; i < N; i++) {
    S.push(Number(input()))
}

let cnt_max = 0
let ans = 0
for (let i = 1; i <= N; i++) {
    const visit = [null, ...Array(N).fill(0)]
    let cur = i
    let cnt = 0
    while (true) {
        if (visit[cur] == 0) {
            visit[cur] = 1
            cur = S[cur]
            cnt += 1
        }
        else {
            break
        }
    }
    if (cnt_max < cnt) {
        cnt_max = cnt
        ans = i
    }
}

console.log(ans)