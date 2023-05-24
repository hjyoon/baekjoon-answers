import sys
input = sys.stdin.readline

while True:
    N = int(input())
    if N == 0:
        break
        
    dp = [float('-inf')]*(N+1)
    for i in range(1, N+1):
        dp[i]=int(input())

    for i in range(1, N+1):
        dp[i] = max(dp[i], dp[i-1] + dp[i])
    
    print(max(dp))