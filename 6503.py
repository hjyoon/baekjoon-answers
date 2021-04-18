import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections

while True:
    m = int(input().rstrip())
    if m == 0:
        break
    s = input().rstrip()

    dq = collections.deque()
    d = {}
    i = 0
    c = 0
    r = 0

    while True:
        if i == len(s):
            break

        t = d.get(s[i], 0)
        if t == 0:
            dq.append(s[i])
            d[s[i]] = 1
            c += 1
        else:
            dq.append(s[i])
            d[s[i]] += 1

        while c > m:
            a = dq.popleft()
            if d[a] == 1:
                c -= 1
            d[a] -= 1

        i += 1
        r = max(r, len(dq))
    print(r)