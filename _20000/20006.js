"use strict"
const stdin = require('fs').readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'input.txt').toString().split('\n');
const input = (() => {
    let line = 0
    return () => stdin[line++]
})();

const find_room = (l, room, m) => {
    let ret = -1
    for (let i = 0; i < room.length; i++) {
        const first_player = room[i][0]
        if (Math.abs(first_player[0] - l) <= 10 && room[i].length < m) {
            ret = i
            break
        }
    }
    return ret
}

const [P, M] = input().split(' ').map(Number)
const room = []
for (let i = 0; i < P; i++) {
    const line = input().trimRight().split(' ')
    const [l, n] = [Number(line[0]), line[1]]
    const idx = find_room(l, room, M)
    if (idx == -1) {
        room.push([[l, n]])
    }
    else {
        room[idx].push([l, n])
    }
}

for (const p_list of room) {
    p_list.sort((a, b) => a[1] > b[1] ? 1 : -1)
    if (p_list.length == M) {
        console.log('Started!')
    }
    else {
        console.log('Waiting!')
    }
    for (const p of p_list) {
        console.log(...p)
    }
}