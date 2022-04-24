import sys
from pprint import pprint
sys.stdin = open('input.txt')
input = sys.stdin.readline


N, M, K = map(int, input().split())

graph = {i: {} for i in range(1, N+1)}

for i in range(K):
    a, b, w = map(int, input().split())
    if a < b:
        if b in graph[a]:
            graph[a][b] = max(graph[a][b], w)
        else:
            graph[a][b] = w

print(graph)
