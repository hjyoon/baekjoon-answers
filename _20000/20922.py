import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections

N, K = map(int, input().rstrip().split())
l = list(map(int, input().rstrip().split()))

dq = collections.deque()
d = {}
i = 0
ans = 0
while i < len(l):
    dq.append(l[i])
    d[l[i]] = d.setdefault(l[i], 0) + 1
    while d.get(l[i], 0) > K:
        t = dq.popleft()
        d[t] -= 1
    ans = max(ans, len(dq))
    i += 1

print(ans)