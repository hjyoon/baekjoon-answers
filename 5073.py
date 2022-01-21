import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

while True:
    a, b, c = sorted(map(int, input().split()))
    if a == b == c == 0:
        break
    if a+b <= c:
        print('Invalid')
    else:
        n = len({a, b, c})
        if n == 1:
            print('Equilateral')
        elif n == 2:
            print('Isosceles')
        else:
            print('Scalene')
