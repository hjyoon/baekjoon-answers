import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline
sys.setrecursionlimit(1000000)

Y, X = map(int, input().rstrip().split())
M = list(map(lambda x:list(map(int, x.rstrip().split())), sys.stdin))
visit = None
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
c = 0
c2 = 0

def chkend():
    r = 0
    for v in M:
        r += sum(v)
    if r == 0:
        return True
    else:
        return False

def arrange():
    global c2
    for i in range(Y):
        for j in range(X):
            if visit[i][j] == 2:
                M[i][j] = 0
                c2 += 1

def dfs(sy, sx):
    if sy < 0 or sx < 0 or sy >= Y or sx >= X:
        return
    if visit[sy][sx] == 1:
        return
    else:
        if M[sy][sx] == 1:
            visit[sy][sx] = 2
            return
        else:
            visit[sy][sx] = 1
    for i in range(4):
        dfs(sy+dy[i], sx+dx[i])

while True:
    if chkend():
        break
    visit = [[0]*X for _ in range(Y)]
    c2 = 0
    dfs(0, 0)
    arrange()
    c += 1

print(c, c2, sep='\n')