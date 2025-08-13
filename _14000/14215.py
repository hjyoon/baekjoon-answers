import sys


def solve():
    a, b, c = sorted(map(int, sys.stdin.readline().rstrip().split()))

    if a + b > c:
        res = a + b + c
    else:
        res = (a + b) * 2 - 1
    print(res)


solve()
