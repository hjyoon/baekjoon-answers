import sys

input = sys.stdin.readline


def solve():
    A = input().rstrip()
    B = input().rstrip()
    C = input().rstrip()
    ans = [int(A) + int(B) - int(C), int(A + B) - int(C)]
    print(*ans, sep="\n")


solve()
