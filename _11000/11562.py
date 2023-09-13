import sys
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())

graph = [[float('inf')]*(N+1) for _ in range(N+1)]
for i in range(1, N+1):
    graph[i][i] = 0


for _ in range(M):
    u, v, b = map(int, input().rstrip().split())
    if b == 1:
        graph[v][u] = 0
        graph[u][v] = 0
    else:
        graph[u][v] = 0
        graph[v][u] = 1

for k in range(1, N+1):
    for i in range(1, N+1):
        for j in range(1, N+1):
            graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j])

S = int(input())
ans = [0] * S
for i in range(S):
    s, e = map(int, input().rstrip().split())
    ans[i] = graph[s][e]

print(*ans, sep='\n')

# print(*graph, sep='\n')
