import sys


def solve():
    input = sys.stdin.readline
    T = int(input())
    for _ in range(T):
        a, b, c = map(int, input().split())
        print(f"Data set: {a} {b} {c}")
        for _ in range(c):
            if a >= b:
                a //= 2
            else:
                b //= 2
        if a >= b:
            print(a, b)
        else:
            print(b, a)
        print()


solve()
