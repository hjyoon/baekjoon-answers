import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import math

N, S = map(lambda x:x.rstrip(), sys.stdin)
A, *S = map(int, S.split())
for v in S:
    g = math.gcd(A, v)
    print(A//g, v//g, sep='/')