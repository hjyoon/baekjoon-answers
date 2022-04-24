import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())
S = []
for i in range(N):
    a, b = map(int, input().rstrip().split())
    S.append((a,b))
L, P = map(int, input().rstrip().split())
S.sort()

import heapq

ans = 0
oil = P
i = 0
out = False
pq = []
heapq.heapify(pq)

while oil < L:
    while i < N and oil >= S[i][0]:
        heapq.heappush(pq, -S[i][1])
        i += 1

    if len(pq) == 0:
        out = True
        break

    a = heapq.heappop(pq)
    oil += -a
    ans += 1

if out:
    print(-1)
else:
    print(ans)