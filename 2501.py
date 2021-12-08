import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

N, K = map(int, input().split())

l = [i for i in range(1, N+1) if N % i == 0]
if len(l) < K:
    print(0)
else:
    print(l[K-1])
