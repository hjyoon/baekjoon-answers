import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = map(int, sys.stdin)

import itertools

for v in itertools.combinations(S, 7):
    if sum(v) == 100:
        print(*sorted(v), sep='\n')
        break