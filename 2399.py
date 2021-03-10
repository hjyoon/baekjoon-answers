import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, S = map(lambda x:x.rstrip(), sys.stdin)
N = int(N)
x = map(int, S.split())
i = enumerate(sorted(x))

import functools
sum = functools.reduce(lambda x, y:x+y[1]*(2*y[0]-N+1), i, 0)
print(sum*2)