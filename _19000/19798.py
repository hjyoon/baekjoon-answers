import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections
import itertools

N = int(input().rstrip())
S = list(map(int, input().rstrip().split()))

dq = collections.deque()

for a, b in itertools.groupby(S):
    dq.append((a, len(list(b))))

ans = 0
idx = 0

while len(dq) > 0:
    t = dq.pop()
    ans += (t[0]-idx) * t[1]
    idx += t[1]
    if len(dq) == 0:
        break
    while dq[0][0] <= idx:
        dq.popleft()
        if len(dq) == 0:
            break

print(ans)