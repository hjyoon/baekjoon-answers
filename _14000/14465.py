import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections

N, K, B = map(int, input().rstrip().split())
S = map(int, sys.stdin)

b = [0] * N
for v in S:
    b[v-1] = 1

dq = collections.deque()
i = 0
c = 0
ans = float('inf')
while i < N:
    if len(dq) < K:
        dq.append(b[i])
        if b[i] == 1:
            c += 1
        i += 1
        continue

    dq.append(b[i])
    if dq[-1] == 1:
        c += 1
    if dq.popleft() == 1:
        c -= 1
    i += 1
    ans = min(ans, c)
print(ans)