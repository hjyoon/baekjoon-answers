import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools

r = (0, 0)
_, *S = map(lambda x:x.rstrip(), sys.stdin)
for i, v in enumerate(S, 1):
    v = map(int, v.split())
    for a, b, c in itertools.permutations(v, 3):
        if (a+b+c)%10 >= r[1]:
            r = (i, (a+b+c)%10)
print(r[0])