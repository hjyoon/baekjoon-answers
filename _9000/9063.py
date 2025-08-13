import sys


def solve():
    N, *S = sys.stdin.read().rstrip().split()
    S = tuple(map(int, S))
    N = int(N)
    if N == 1:
        print(0)
        exit()

    list_x = S[::2]
    list_y = S[1::2]

    x1, y1 = min(list_x), min(list_y)
    x2, y2 = max(list_x), max(list_y)

    print((x2 - x1) * (y2 - y1))


solve()
