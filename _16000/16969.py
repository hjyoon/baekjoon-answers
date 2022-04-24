import sys
sys.setrecursionlimit(10**9)
sys.stdin = open('input.txt')
input = sys.stdin.readline


def dfs(S, i):
    if i == len(S):
        return 1

    ret = 0
    if i > 0 and S[i-1] == 'd' and S[i] == 'd':
        ret = 9 * dfs(S, i+1)
    elif i > 0 and S[i-1] == 'c' and S[i] == 'c':
        ret = 25 * dfs(S, i+1)
    elif S[i] == 'd':
        ret = 10 * dfs(S, i+1)
    else:
        ret = 26 * dfs(S, i+1)

    return ret % 1000000009


S = input().rstrip()
print(dfs(S, 0))
