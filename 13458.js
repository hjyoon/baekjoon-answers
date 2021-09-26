const stdin = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'input.txt').toString().split('\n');
const input = (() => {
    let line = 0
    return () => stdin[line++].replace('\r', '')
})();

const N = input()
const S = input().split(' ').map(Number)
const [B, C] = input().split(' ').map(Number)

let ans = 0
for (let v of S) {
    ans++
    if (v < B) {
        continue
    }
    v -= B
    if (v % C == 0) {
        ans += Number(v / C)
    }
    else {
        ans += Math.floor(v / C) + 1
    }
}
console.log(ans)