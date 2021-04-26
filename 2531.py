import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections

N, d, k, c = map(int, input().rstrip().split())
l = []
for i in range(N):
    l.append(int(input().rstrip()))

dq = collections.deque()
t = {}
cnt = 0
ans = 0
for i in range(k):
    dq.append(l[i])
    if l[i] not in t:
        t[l[i]] = 1
        cnt += 1
    else:
        t[l[i]] += 1

i = k
while True:
    if i == k-1:
        break

    dq.append(l[i])
    if l[i] not in t:
        t[l[i]] = 1
        cnt += 1
    else:
        t[l[i]] += 1

    tt = dq.popleft()
    if tt in t:
        if t[tt] == 1:
            del t[tt]
            cnt -= 1
        else:
            t[tt] -= 1

    if c not in t:
        ans = max(ans, cnt+1)
    else:
        ans = max(ans, cnt)

    i = (i+1) % N
    #print(t, cnt)

print(ans)