import sys
from collections import deque

input = sys.stdin.readline

def find_item():
    for i in range(N):
        for j in range(M):
            if board[i][j] == 2:
                return i, j

def bfs(start_y, start_x, end_y, end_x):
    visit = [[0]*M for _ in range(N)]
    queue = deque()
    queue.append([start_y, start_x, 0])
    visit[start_y][start_x] = 1
    while queue:
        y, x, t = queue.popleft()
        if y == end_y and x == end_x:
            return t
        for dy, dx in (0, 1), (1, 0), (0, -1), (-1, 0):
            if y+dy < 0 or y+dy >= N or x+dx < 0 or x+dx >= M:
                continue
            if visit[y+dy][x+dx] == 1:
                continue
            if board[y+dy][x+dx] == 1:
                continue
            visit[y+dy][x+dx] = 1
            queue.append([y+dy, x+dx, t+1])
    return float('inf')

N, M, T = map(int, input().split())
board = [[*map(int, input().split())] for _ in range(N)]
item_y, item_x = find_item()

res = bfs(0, 0, N - 1, M - 1)
res2 = bfs(0, 0, item_y, item_x)
res3 = abs(item_y-(N-1)) + abs(item_x-(M-1))

ans = min(res, res2 + res3)
if ans <= T:
    print(ans)
else:
    print("Fail")