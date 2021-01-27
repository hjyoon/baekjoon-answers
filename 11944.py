import sys
sys.stdin = open("input.txt", 'r')

N, M = input().split()
M = int(M)
res = N * int(N)
print(res[:M])