import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, *S = map(lambda x:x.rstrip(), sys.stdin)
N = int(N)
l = [[0]*101 for _ in range(101)]
for i, v in enumerate(S, 1):
    x, y, w, h = map(int, v.split())
    for j in range(h):
        for k in range(w):
            l[y+j][x+k] = i

import itertools
l = tuple(itertools.chain(*l))
# for i in range(1, N+1):
#     print(l.count(i))
[print(l.count(i)) for i in range(1, N+1)]