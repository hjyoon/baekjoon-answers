"use strict"
const stdin = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'input.txt').toString().split('\n');
const input = (() => {
    let line = 0
    return () => stdin[line++]
})();

const N = Number(input())
const S = [...Array(N)].map(() => input().trimRight().split(' ').map((v) => Number(v)))
const dp = [...Array(2)].map(() => Array(3).fill(0));


[dp[0][0], dp[0][1], dp[0][2]] = S[0]
for (let i = 1; i < N; i++) {
    dp[1][0] = S[i][0] + Math.min(dp[0][1], dp[0][2])
    dp[1][1] = S[i][1] + Math.min(dp[0][0], dp[0][2])
    dp[1][2] = S[i][2] + Math.min(dp[0][0], dp[0][1]);
    [dp[0][0], dp[0][1], dp[0][2]] = dp[1]
}

console.log(Math.min(...dp[1]))
