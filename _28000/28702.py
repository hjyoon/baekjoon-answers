import sys

input = sys.stdin.readline


def solve():
    a = input().rstrip()
    b = input().rstrip()
    c = input().rstrip()

    n = 0
    if a[0] in "123456789":
        n = int(a) + 3
    elif b[0] in "123456789":
        n = int(b) + 2
    else:
        n = int(c) + 1

    if n % 3 == 0 and n % 5 == 0:
        print("FizzBuzz")
    elif n % 3 == 0:
        print("Fizz")
    elif n % 5 == 0:
        print("Buzz")
    else:
        print(n)


solve()
