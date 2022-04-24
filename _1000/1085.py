import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

x, y, w, h = map(int, input().split())
res = min(abs(x-w), abs(y-h), x, y)
print(res)
