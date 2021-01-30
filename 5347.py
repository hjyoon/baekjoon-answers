import sys
sys.stdin = open("input.txt", 'r')

T, *S = map(lambda x: x.rstrip(), sys.stdin)

import math

for i in S:
    a, b = map(int, i.split())
    print(math.lcm(a, b))