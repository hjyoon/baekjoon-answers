import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A, B, C = map(int, input().split())
l = [A, B, C, A*B, A*C, B*C, A*B*C]
l = sorted(l, key=lambda x: x % 2)
print(l[-1])
