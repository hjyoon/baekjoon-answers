import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

dirc = {
    0: (-1, 0),  # 북쪽
    1: (0, 1),  # 동쪽
    2: (1, 0),  # 남쪽
    3: (0, -1),  # 서쪽
}

change_d = {
    0: 3,  # 북 -> 서
    3: 2,  # 서 -> 남
    2: 1,  # 남 -> 동
    1: 0,  # 동 -> 북
}


def solve(y, x, d):
    ret = 1
    visit[y][x] = 1
    while True:
        i = 0
        while True:
            d = change_d[d]
            dy, dx = y+dirc[d][0], x+dirc[d][1]
            if board[dy][dx] == 0:
                if visit[dy][dx] == 0:
                    visit[dy][dx] = 1
                    y, x = dy, dx
                    ret += 1
                    break
            i += 1
            if i == 4:
                y, x = y-dirc[d][0], x-dirc[d][1]
                break

        if board[y][x] == 1:
            break

    return ret


R, C = map(int, input().split())
y, x, d = map(int, input().split())
board = [tuple(map(int, input().split())) for _ in range(R)]
visit = [[0]*C for _ in range(R)]

ans = solve(y, x, d)
print(ans)
