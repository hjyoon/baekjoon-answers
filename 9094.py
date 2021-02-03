import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools
T, *S = map(lambda x:x.rstrip(), sys.stdin)
for i in S:
    N, M = map(int, i.split())
    c = itertools.combinations(range(1, N), 2)
    cnt = 0
    for j in c:
        num = (j[0]**2 + j[1]**2 + M) / (j[0] * j[1])
        if num == int(num):
            cnt += 1
    print(cnt)