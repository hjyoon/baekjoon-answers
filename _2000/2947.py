import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = list(map(int, input().split()))
for i in range(0, len(N)):
    for j in range(1, len(N)-i):
        if N[j-1] > N[j]:
            N[j-1], N[j] = N[j], N[j-1]
            print(*N)