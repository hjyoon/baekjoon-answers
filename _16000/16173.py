from pprint import pprint
import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

dy = (0, 1)
dx = (1, 0)


def dfs(y, x):
    if y < 0 or x < 0 or y >= N or x >= N:
        return
    #print(y, x, cnt)
    if visit[y][x] == 1:
        return

    #print(y, x)

    if y == N-1 and x == N-1:
        # print('success')
        return True

    cnt = board[y][x]
    for i in range(2):
        visit[y][x] = 1
        ret = dfs(y+(dy[i]*cnt), x+(dx[i]*cnt))
        if ret:
            return ret
        visit[y][x] = 0


N = int(input())
board = [tuple(map(int, input().split())) for _ in range(N)]
visit = [[0]*N for _ in range(N)]

if dfs(0, 0):
    print('HaruHaru')
else:
    print('Hing')
