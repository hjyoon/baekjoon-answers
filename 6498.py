from pprint import pprint
import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

while True:
    N = int(input())
    if N == 0:
        break
    C = list(map(int, input().split()))
    dp = [[0]*(N+1) for _ in range(N+1)]
    for i in range(N):
        tmp_sum = 0
        for j in range(i+1+1):
            dp[i+1][j] = float('inf')
        for j in range(i, -1, -1):
            tmp_sum += C[j]
            for k in range(j+1):
                dp[i+1][k+1] = min(dp[i+1][k+1], dp[j][k] + tmp_sum * (k+i+2))
                if dp[i+1][k+1] == 75:
                    print(dp[i+1][k+1], dp[j][k], tmp_sum, (k+i+2))
    ans = float('inf')
    for i in range(1, N+1):
        ans = min(ans, dp[N][i])
    print(*dp)
    print(ans)
