import sys
from pprint import pprint
sys.setrecursionlimit(10**9)
sys.stdin = open('input.txt')
input = sys.stdin.readline

dp = [None] * 28
dp[0] = 'moo'


def moo(k):
    if dp[k] != None:
        return dp[k]
    else:
        dp[k] = moo(k-1) + ('m'+'o'*(k+2)) + moo(k-1)
        return dp[k]


N = int(input())
ans = moo(27)
# print(ans)
# print(len(ans))
print(ans[N-1])
