from collections import deque
from collections import defaultdict
import sys
input = sys.stdin.readline

R, C = map(int, input().split())

board = [input().rstrip() for _ in range(R)]

start_pos = []

for i in range(R):
    for j in range(C):
        if board[i][j] == 'o':
            start_pos.append((i,j))

def bfs2(y1, x1, y2, x2):
    visited = defaultdict(int)
    q = deque([(y1, x1, y2, x2, 0)])
    while q:
        ny1, nx1, ny2, nx2, step = q.popleft()

        if step >= 10:
            continue
        
        if visited[f'{ny1},{nx1},{ny2},{nx2}']:
            continue
        visited[f'{ny1},{nx1},{ny2},{nx2}'] = 1

        for dy, dx in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
            flag1, flag2 = 0, 0
            ty1, tx1, ty2, tx2 = ny1, nx1, ny2, nx2
            if ny1+dy < 0 or ny1+dy >= R or nx1+dx < 0 or nx1+dx >= C:
                flag1 = 1
            if ny2+dy < 0 or ny2+dy >= R or nx2+dx < 0 or nx2+dx >= C:
                flag2 = 1
            if flag1 + flag2 == 1:
                return step + 1
            elif flag1 + flag2 == 2:
                continue
            if board[ny1+dy][nx1+dx] != '#':
                ty1, tx1 = ny1+dy, nx1+dx
            if board[ny2+dy][nx2+dx] != '#':
                ty2, tx2 = ny2+dy, nx2+dx
            q.append((ty1,tx1,ty2,tx2,step+1))
    return -1

print(bfs2(start_pos[0][0], start_pos[0][1], start_pos[1][0], start_pos[1][1]))