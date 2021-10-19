import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline


N = int(input())
S = tuple(map(int, input().split()))
dp = [0] * 50
for v in S:
    dp[v-1] += 1

ans = dp[0]
for i in range(1, 50):
    if dp[i] == 0:
        break
    dp[i] *= dp[i-1]
    ans += dp[i]

print(ans)
