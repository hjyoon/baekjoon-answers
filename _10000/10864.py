import sys
sys.stdin = open("input.txt", 'r')

N, M = map(int, input().split())
r = [0] * N
for _ in range(M):
    A, B = map(int, input().split())
    r[A-1] += 1
    r[B-1] += 1
for i in r:
    print(i)