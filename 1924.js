const stdin = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'input.txt').toString().split('\n');
const input = (() => {
    let line = 0
    return () => stdin[line++].replace('\r', '')
})();

[X, Y] = input().split(' ').map(Number)

month = [null, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
day = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']

total = 0
for (let i = 1; i < X; i++) {
    total += month[i]
}
total += Y

console.log(day[total % 7])