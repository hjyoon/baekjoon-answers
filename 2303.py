import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools

r = (0, 0)
_, *S = map(lambda x:x.rstrip(), sys.stdin)
for i, v in enumerate(S, 1):
    v = map(int, v.split())
    for a, b, c in itertools.combinations(v, 3):
        c = (a+b+c)%10
        if c >= r[1]:
            r = (i, c)
print(r[0])