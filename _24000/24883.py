import sys


def solve():
    input = sys.stdin.readline
    C = input().rstrip()
    if C == "N" or C == "n":
        print("Naver D2")
    else:
        print("Naver Whale")


solve()
