import sys
sys.stdin = open("input.txt", 'r')
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

M, N, K = map(int, input().rstrip().split())
m = [[0]*N for _ in range(M)]
visit = [[0]*N for _ in range(M)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
C = 0

def dfs(y, x, c):
    global N, M, C
    if x < 0 or y < 0 or x >= N or y >= M:
        return
    if visit[y][x] == 1:
        return
    if m[y][x] == 1:
        return
    visit[y][x] = 1
    C += 1
    for i in range(4):
        dfs(y+dy[i], x+dx[i], c+1)
    return

for _ in range(K):
    x1, y1, x2, y2 = map(int, input().rstrip().split())
    for i in range(y1, y2):
        for j in range(x1, x2):
            m[i][j] = 1

r = []
for i in range(M):
    for j in range(N):
        dfs(i, j, 1)
        if C > 0:
            r.append(C)
        C = 0
r.sort()
print(len(r))
print(*r)