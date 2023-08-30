from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
S = [input().rstrip() for _ in range(N)]

visited = [[float('inf')]*N for _ in range(N)]


def bfs(y, x):
    q = deque([(y, x, 0)])
    while q:
        ny, nx, nc = q.popleft()
        flag = False
        if ny >= N or ny < 0 or nx >= N or nx < 0:
            continue
        if S[ny][nx] == '0':
            flag = True
        if [nc, nc+1][flag] >= visited[ny][nx]:
            continue
        visited[ny][nx] = [nc, nc+1][flag]
        for dy, dx in ((0, 1), (1, 0), (0, -1), (-1, 0)):
            if not flag:
                q.appendleft((ny+dy, nx+dx, [nc, nc+1][flag]))
            else:
                q.append((ny+dy, nx+dx, [nc, nc+1][flag]))


bfs(0, 0)

print(visited[N-1][N-1])
