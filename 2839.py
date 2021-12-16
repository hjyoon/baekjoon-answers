import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline


def my_min(i, j):
    if dp[i] == -1 and dp[j] == -1:
        return -1
    elif dp[i] == -1:
        return dp[j] + 1
    elif dp[j] == -1:
        return dp[i] + 1
    else:
        return min(dp[i], dp[j]) + 1


dp = [-1]*5001
dp[3] = 1
dp[5] = 1

N = int(input())
for i in range(6, N+1):
    dp[i] = my_min(i-3, i-5)

print(dp[N])
