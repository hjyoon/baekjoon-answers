import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

M, N = map(int, input().split())

board = [[0]*N for _ in range(M)]
x, y = -1, 0
d = [(1, 0), (0, 1), (-1, 0), (0, -1)]
i = 0
cnt = 0
res = 0
while cnt != N*M:
    tmpx = x + d[i][0]
    tmpy = y + d[i][1]
    if 0 <= tmpx < N and 0 <= tmpy < M and board[tmpy][tmpx] == 0:
        x, y = tmpx, tmpy
        cnt += 1
        board[tmpy][tmpx] = cnt
    else:
        i = (i+1) % 4 # 방향 바꾸기
        res += 1

print(res)