from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())

graph_list = [list() for _ in range(N+1)]
colors = [0] * (N+1)

for i in range(M):
    X, Y = map(int, input().split())
    graph_list[X].append(Y)
    graph_list[Y].append(X)

def bfs(root, color):
    q = deque([(root,color)])
    while q:
        now_node, now_color = q.popleft()
        if colors[now_node] != 0:
            continue
        colors[now_node] = now_color
        for next in graph_list[now_node]:
            if colors[next] == 0:
                q.append((next, [1, 2][now_color==1]))
            else:
                if colors[next] == now_color:
                    print(0)
                    exit(0)

for i in range(1, N+1):
    if colors[i] == 0:
        bfs(i, 1)

print(1)