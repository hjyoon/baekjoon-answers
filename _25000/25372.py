import sys


def solve():
    input = sys.stdin.readline
    N = int(input())
    res = []
    for _ in range(N):
        l = len(input().rstrip())
        res.append("yes" if l >= 6 and l <= 9 else "no")

    print(*res, sep="\n")


solve()
