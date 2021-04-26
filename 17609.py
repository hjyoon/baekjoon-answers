import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline
sys.setrecursionlimit(100000000)

N = int(input().rstrip())
l = []
for i in range(N):
    l.append(input().rstrip())

def dfs(s, left, right, c):
    if c > 1:
        return c
    if left > right:
        return c
    while s[left] == s[right]:
        left += 1
        right -= 1
        if left > right:
            return c
    else:
        a = dfs(s, left+1, right, c+1)
        b = dfs(s, left, right-1, c+1)
        return min(a, b)

for s in l:
    ans = dfs(s, 0, len(s)-1, 0)
    print(ans)
