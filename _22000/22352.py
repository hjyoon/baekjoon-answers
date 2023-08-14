import sys
input = sys.stdin.readline

R, C = map(int, input().split())

S1 = [[int(i) for i in input().split()] for _ in range(R)]
S2 = [[int(i) for i in input().split()] for _ in range(R)]

# print(*dif, sep='\n', file=sys.stderr)

def dfs(y, x, s, visit, v, init):
    if 0 <= y < R and 0 <= x < C and visit[y][x] == 0 and s[y][x] == init:
        visit[y][x] = 1
        s[y][x] = v
        dy = [0, 1, 0, -1]
        dx = [1, 0, -1, 0]
        for i in range(4):
            dfs(y+dy[i], x+dx[i], s, visit, v, init)

def comp(chk1, chk2):
    for i in range(R):
        if chk1[i] != chk2[i]:
            return False
    return True

for i in range(R):
    for j in range(C):
        tmp = [l[:] for l in S1]
        visit = [[0]*C for _ in range(R)]
        dfs(i, j, tmp, visit, S2[i][j], tmp[i][j])
        if comp(tmp, S2):
            print('YES')
            exit(0)

print('NO')
