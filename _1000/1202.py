import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import heapq

pq = []
heapq.heapify(pq)

l = []
m = []

N, K = map(int, input().rstrip().split())
for _ in range(N):
    M, V = map(int, input().rstrip().split())
    l.append((M, V))
l.sort()

for _ in range(K):
    C = int(input().rstrip())
    m.append(C)
m.sort()

i = 0
r = 0
for v in m:
    while True:
        if i >= len(l):
            break
        a, b = l[i]
        if a > v:
            break
        heapq.heappush(pq, -b)
        i += 1
    if len(pq) > 0:
        r += -heapq.heappop(pq)

print(r)