import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import math
import itertools

S = map(int, input().rstrip().split())

m = 1000001
for v in itertools.combinations(S, 3):
    a, b, c = v
    tmp = math.lcm(a, math.lcm(b, c))
    m = min(m, tmp)
print(m)