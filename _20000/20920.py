import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections

N, M = map(int, input().rstrip().split())
S = map(lambda x:x.rstrip(), sys.stdin)
S = sorted(filter(lambda x:len(x)>=M, S))

c = list(collections.Counter(S).items())
c.sort(key=lambda x:(-x[1], -len(x[0]), x[0]))
for v in c:
    print(v[0])