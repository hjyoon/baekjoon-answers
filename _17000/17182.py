import sys
input = sys.stdin.readline

N, K = map(int, input().rstrip().split())

graph = [list(map(int, input().rstrip().split())) for _ in range(N)]

for k in range(N):
    for i in range(N):
        for j in range(N):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

ans = float('inf')

visited = [0]*N


def dfs(now, ac, cnt):
    global ans

    if visited[now] == 1:
        return

    visited[now] = 1

    if ac >= ans:
        visited[now] = 0
        return

    if cnt == N:
        ans = ac
        visited[now] = 0
        return

    for next in range(N):
        if next == now:
            continue
        dfs(next, ac + graph[now][next], cnt+1)

    visited[now] = 0


dfs(K, 0, 1)

print(ans)
