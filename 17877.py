import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools
import math

N, D = map(int, input().rstrip().split())
S = map(int, input().rstrip().split())
S = sorted(map(lambda x:x//D, S))
ans = 0
for v, i in itertools.groupby(S):
    ans += math.comb(len(list(i)), 2)
print(ans)