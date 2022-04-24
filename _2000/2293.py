import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, K = map(int, input().rstrip().split())
S = list(map(int, sys.stdin))

dp = [0] * 10001
dp[0] = 1

for i in range(N):
    for j in range(S[i], K+1):
        if j - S[i] >= 0:
            dp[j] += dp[j - S[i]]

print(dp[K])