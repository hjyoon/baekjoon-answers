import sys
from pprint import pprint
sys.setrecursionlimit(10**9)
sys.stdin = open('input.txt')
input = sys.stdin.readline


N, K, C = map(int, input().split())
A = sorted(map(int, input().split()))

for i in range(N):
    while A[i] > 1 and C > 0:
        A[i] -= 1
        C -= 1

print(A)
