import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

def f(x):
    t = B.index(x)
    B[t] = -1
    return t

import copy
N = int(input())
A = list(map(int, input().split()))
B = sorted(A)
C = map(f, A)
print(*C)