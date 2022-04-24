import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
A = list(map(int, sys.stdin))

for i in range(1, M+1):
    for j in range(0, len(A)-1):
        if A[j]%i > A[j+1]%i:
            A[j], A[j+1] = A[j+1], A[j]
print(*A, sep='\n')