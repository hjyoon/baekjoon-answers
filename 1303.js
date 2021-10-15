const stdin = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'input.txt').toString().split('\n');
const input = (() => {
    let line = 0
    return () => stdin[line++]
})();

const dfs = (board, visit, y, x, color) => {
    const [R, C] = [board.length, board[0].length]

    if (y < 0 || y >= R || x < 0 || x >= C) {
        return 0
    }

    if (visit[y][x]) {
        return 0
    }

    if (board[y][x] != color) {
        return 0
    }

    visit[y][x] = 1

    const d_pos = [[-1, 0], [0, 1], [1, 0], [0, -1]]

    let ret = 1
    for (const [dy, dx] of d_pos) {
        ret += dfs(board, visit, y + dy, x + dx, color)
    }
    return ret
}

const [C, R] = input().split(' ').map(Number)
const board = [...Array(R)].map(() => input().trimRight())
const visit = [...Array(R)].map(() => Array(C).fill(0))
let [w_ans, b_ans] = [0, 0]

for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
        if (!visit[i][j]) {
            const color = board[i][j]
            const tmp = dfs(board, visit, i, j, color)
            if (color == 'W') {
                w_ans += tmp ** 2
            }
            else {
                b_ans += tmp ** 2
            }
        }
    }
}

console.log(w_ans, b_ans)
