import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(int, sys.stdin)

t = [i*(i+1)//2 for i in range(1,45)]

import itertools
i = tuple(itertools.combinations_with_replacement(range(len(t)), 3))

def chk(v):
    for e in i:
        x, y, z = e
        if t[x]+t[y]+t[z] == v:
            return True
    return False

for v in S:
    if chk(v):
        print(1)
    else:
        print(0)