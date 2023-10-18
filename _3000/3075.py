import sys
input = sys.stdin.readline

T = int(input())

while T > 0:
    T -= 1

    N, P, Q = map(int, input().rstrip().split())

    indices = []
    graph = [[float('inf')]*P for _ in range(P)]

    for i in range(P):
        graph[i][i] = 0

    for _ in range(N):
        indices.append(int(input())-1)

    for _ in range(Q):
        i, j, d = map(int, input().rstrip().split())
        if d < graph[i-1][j-1]:
            graph[i-1][j-1] = d
            graph[j-1][i-1] = d

    for k in range(P):
        for i in range(P):
            for j in range(P):
                if graph[i][k] + graph[k][j] < graph[i][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]

    ans = [None, float('inf')]
    for i in range(P):
        tmp = 0
        for j in indices:
            tmp += (graph[i][j] ** 2)
        if tmp < ans[1]:
            ans = [i+1, tmp]

    print(*ans, sep=' ')
