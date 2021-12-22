import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A, B, C, D = map(int, input().split())
S = map(int, input().split())

res = [0] * 3

for i, n in enumerate(S):
    if (n-1) % (A+B) < A:
        res[i] += 1
    if (n-1) % (C+D) < C:
        res[i] += 1

print(*res, sep='\n')
