import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

T = int(input())

for v in range(T):
    M, N = input().split()
    M = int(M)
    S = input().split()
    if N == 'C':
        print(*[ord(v)-64 for v in S])
    else:
        print(*[chr(int(v)+64) for v in S])