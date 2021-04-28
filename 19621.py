import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())
l = []
for i in range(N):
    l.append(list(map(int, input().rstrip().split())))

ans = float('-inf')
def dfs(i, s):
    global ans
    if i >= N:
        ans = max(ans, s)
        return
    else:
        s += l[i][2]
    for j in range(i+2, N+2):
        dfs(j, s)

dfs(0, 0)
if N > 1:
    dfs(1, 0)
print(ans)