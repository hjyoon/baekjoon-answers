import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

N = int(input())
S = tuple(map(int, input().split()))
ans = 0

for i in range(N):
    for j in range(i+1, N):
        ans = max(ans, (j-i-1) * min(S[i], S[j]))

print(ans)