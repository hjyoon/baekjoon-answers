import sys

input = sys.stdin.readline


def solve():
    s = input().rstrip()
    n = int(input())
    print(s[n - 1])


solve()
