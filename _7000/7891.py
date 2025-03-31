import sys


def solve():
    input = sys.stdin.readline
    N = int(input())
    ans = []
    for _ in range(N):
        x, y = map(int, input().rstrip().split())
        ans.append(x + y)
    print(*ans, sep="\n")


solve()
