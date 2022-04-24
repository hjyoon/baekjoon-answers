import sys
sys.stdin = open("input.txt", 'r')

a, b = map(int, input().split())
print(2*b - a)
