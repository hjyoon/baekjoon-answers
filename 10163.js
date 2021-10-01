const stdin = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'input.txt').toString().split('\n');
const input = (() => {
    let line = 0
    return () => stdin[line++].replace('\r', '')
})();

N = Number(input())
board = [...Array(1001)].map(() => Array(1001).fill(0))

put_paper = (x, y, w, h, color, board) => {
    for (let i = y; i < y + h; i++) {
        for (let j = x; j < x + w; j++) {
            board[i][j] = color
        }
    }
}

for (let i = 1; i <= N; i++) {
    [x, y, w, h] = input().split(' ').map(Number)
    put_paper(x, y, w, h, i, board)
}

visible_area = [...Array(N + 1)].fill(0)

for (let i = 0; i < 1001; i++) {
    for (let j = 0; j < 1001; j++) {
        c = board[i][j]
        if (c != 0) {
            visible_area[c]++
        }
    }
}

for (let n of visible_area.slice(1)) {
    console.log(n)
}