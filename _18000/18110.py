import sys

input = sys.stdin.readline


def solve():
    _, *S = map(int, sys.stdin)
    if not S:
        print(0)
        return
    S.sort()
    cut = int(len(S) * 0.15 + 0.5)
    print(int(sum(S[cut : len(S) - cut]) / (len(S) - cut * 2) + 0.5))


solve()
