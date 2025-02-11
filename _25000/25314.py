import sys

input = sys.stdin.readline


def solve():
    n = int(input())
    buf = ["long" for _ in range(n // 4)] + ["int"]
    print(" ".join(buf))


solve()
