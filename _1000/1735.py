import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A, B = map(int, input().split())
C, D = map(int, input().split())

import math
t = math.gcd(A*D+C*B, B*D)
print((A*D+C*B)//t, (B*D//t))