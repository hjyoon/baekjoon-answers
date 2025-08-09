import sys
from functools import reduce


def solve():
    input = sys.stdin.readline
    w = (6, 3, 2, 1, 2)
    A = reduce(
        lambda ac, v: ac + v[1] * w[v[0]],
        enumerate(map(int, input().rstrip().split())),
        0,
    )
    B = reduce(
        lambda ac, v: ac + v[1] * w[v[0]],
        enumerate(map(int, input().rstrip().split())),
        0,
    )
    print(A, B)


solve()
