import sys
sys.setrecursionlimit(1000000)
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline


_, *S = map(lambda x:x.rstrip(), sys.stdin)
N, M = map(int, _.split())

m = []
d = [[-1]*M for _ in range(N)]

for v in S:
    m.append(list(map(int, v.split())))
d[0][0] = m[0][0]

def dfs(y, x):
    if y < 0 or x < 0:
        return 0

    if y == 0 and x == 0:
        return d[y][x]

    if d[y][x] != -1:
        return d[y][x]

    a = m[y][x] + dfs(y-1, x-1)
    b = m[y][x] + dfs(y-1, x)
    c = m[y][x] + dfs(y, x-1)

    d[y][x] = max(a, b, c)
    return d[y][x]

print(dfs(N-1, M-1))