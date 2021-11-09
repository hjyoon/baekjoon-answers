import sys
sys.setrecursionlimit(10**9)
sys.stdin = open('input.txt')
input = sys.stdin.readline


def dfs(n):
    if n == 1:
        return 1
    else:
        return (n * dfs(n-2)) % 1000000007


N = int(input())
print(dfs(N-1))
