import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

x1, y1 = map(int,input().split())
x2, y2 = map(int,input().split())
x3, y3 = map(int,input().split())

resx = x1 ^ x2 ^ x3
resy = y1 ^ y2 ^ y3

print(f'{resx} {resy}')