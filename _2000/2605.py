import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections
d = collections.deque()
tmp = collections.deque()

N, S = map(lambda x:x.rstrip(), sys.stdin)
S = map(int, S.split())
for i, v in enumerate(S, 1):
    for j in range(v):
        tmp.append(d.pop())
    d.append(i)
    for j in range(v):
        d.append(tmp.pop())

print(*d)