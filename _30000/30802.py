import sys
import math

input = sys.stdin.readline


def solve():
    N = int(input())
    A = tuple(map(int, input().split()))
    T, P = map(int, input().split())
    print(sum(map(lambda n: math.ceil(n / T), A)))
    print(N // P, N % P)


solve()
