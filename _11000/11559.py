import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline


def dfs(y, x, color, board, visit):
    dy = (-1, 0, 1, 0)
    dx = (0, 1, 0, -1)

    if y < 0 or y >= 6 or x < 0 or x >= 12:
        return 0, []

    if visit[y][x] == 1:
        return 0, []

    if board[y][x] != color:
        return 0, []

    visit[y][x] = 1
    ret = 1
    ret_track = [(y, x)]
    for i in range(4):
        a, b = dfs(y+dy[i], x+dx[i], color, board, visit)
        ret += a
        ret_track.extend(b)
    return ret, ret_track


def bomb(board, bomb_list):
    for y, x in bomb_list:
        board[y][x] = 'X'

    while True:
        flag = True
        for i in range(6):
            for j in range(12):
                if board[i][j] == 'X':
                    del board[i][j]
                    board[i].append('.')
                    flag = False
        if flag:
            break


src = [input().rstrip() for _ in range(12)]
src = zip(*src[::-1])
board = [list(v[::]) for v in src]
ans = 0

while True:
    total_bomb_list = []
    for i in range(6):
        for j in range(12):
            if board[i][j] != '.':
                visit = [[0]*12 for _ in range(6)]
                cnt, bomb_list = dfs(i, j, board[i][j], board, visit)
                if cnt >= 4:
                    total_bomb_list.extend(bomb_list)
    if total_bomb_list:
        bomb(board, total_bomb_list)
        ans += 1
    else:
        break

print(ans)
