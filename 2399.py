import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, S = map(lambda x:x.rstrip(), sys.stdin)
x = map(int, S.split())
import itertools
i = itertools.combinations(x, 2)

import functools
sum = functools.reduce(lambda x, y:x+abs(y[0]-y[1]), i, 0)
print(sum*2)