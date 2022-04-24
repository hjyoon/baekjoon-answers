import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline


S = input().rstrip()
N = int(input().rstrip())
A = []
for i in range(N):
    A.append(input().rstrip())

dp = [0] * len(S)
ans = 0

def dfs(pos):
    global ans
    if ans == 1 or pos >= len(S):
        ans = 1
        return
    if dp[pos] == 1:
        return
    dp[pos] = 1
    for v in A:
        if S[pos:pos+len(v)] == v:
            dfs(pos+len(v))

dfs(0)
print(ans)