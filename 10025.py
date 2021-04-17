import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections

N, K = map(int, input().rstrip().split())
l = []
for i in range(N):
    g, x = map(int, input().rstrip().split())
    l.append((x, g))
l.sort()

s = 0
r = 0
d = collections.deque()
i = 0
while True:
    if len(d) == 0:
        d.append(l[i])
        s += l[i][1]
        i += 1
        continue

    if i < len(l):  
        if l[i][0] - d[0][0] + 1 <= (K*2+1):
            d.append(l[i])
            s += l[i][1]
            i += 1
        else:
            s -= d[0][1]
            d.popleft()

    r = max(r, s)

    if i >= len(l):
        break
print(r)