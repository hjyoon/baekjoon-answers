import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

y, x = map(int, input().split())

if x >= y:
    print(2*y - 2)
else:
    print(x - 1 + x)