import sys
input = sys.stdin.readline

N, K = map(int, input().rstrip().split())

graph = [[0]*(N+1) for _ in range(N+1)]

for _ in range(K):
    s, t = map(int, input().rstrip().split())
    graph[s][t] = 1

for i in range(1, N+1):
    for j in range(1, N+1):
        for k in range(1, N+1):
            if graph[i][k] == 1 and graph[k][j] == 1:
                graph[i][j] = 1

S = int(input())
ans = [0] * S
for i in range(S):
    s, t = map(int, input().rstrip().split())
    if graph[s][t] == 0 and graph[t][s] == 0:
        ans[i] = 0
    else:
        if graph[s][t] == 1:
            ans[i] = -1
        else:
            ans[i] = 1

print(*ans, sep='\n')
