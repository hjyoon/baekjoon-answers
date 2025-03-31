import sys


def solve():
    input = sys.stdin.readline
    R = int(input())
    C = int(input())
    ans = []
    for _ in range(R):
        ans.append("*" * C)
    print(*ans, sep="\n")


solve()
