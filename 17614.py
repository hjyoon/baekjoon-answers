import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

N = input().rstrip()

dp = [[0] * 10 for _ in range(8)]
dp[1] = [0, 0, 0, 1, 0, 0, 1, 0, 0, 1]

for i in range(2, 8):
    tmp = sum(dp[i-1])
    for j in range(10):
        if j in [3, 6, 9]:
            dp[i][j] = tmp + 10**(i-1)
        else:
            dp[i][j] = tmp


def rc(s):
    if len(s) == 1:
        a = 0
        for i in range(int(s[0])+1):
            a += dp[len(s)][i]
        return a
    else:
        a = 0
        for i in range(int(s[0])):
            a += dp[len(s)][i]
        if s[0] in ['3', '6', '9']:
            a += int(s[1:])+1
        return a + rc(s[1:])


print(rc(N))
