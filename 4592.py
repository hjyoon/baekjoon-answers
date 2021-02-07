import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools

*N, _ = map(lambda x:x.rstrip(), sys.stdin)
for i in N:
    _, *i = map(int, i.split())
    i = map(lambda x:str(x[0]), itertools.groupby(i))
    print(f'{" ".join(i)} $')