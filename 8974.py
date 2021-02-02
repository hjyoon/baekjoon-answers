import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A, B = map(int, input().split())

m = []
for i in range(1, 46):
    m += [i] * i

print(sum(m[A-1:B]))