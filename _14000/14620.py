import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input())

board = [list(map(int, input().split())) for _ in range(N)]

def chk(board, l):
    res = 0
    n = len(board)
    visit = [[0]*n for _ in range(n)]
    dy = [-1, 0, 1, 0]
    dx = [0, 1, 0, -1]
    for v in l:
        y, x = v//n, v%n
        visit[y][x] = 1
        res += board[y][x]
        for i in range(4):
            if y+dy[i] < 0 or y+dy[i] >= n or x+dx[i] < 0 or x+dx[i] >= n:
                return -1
            if visit[y+dy[i]][x+dx[i]] == 1:
                return -1
            visit[y+dy[i]][x+dx[i]] = 1
            res += board[y+dy[i]][x+dx[i]]
        
    return res

ans = 200*5*3

for i in range(N*N):
    for j in range(i+1, N*N):
        for k in range(j+1, N*N):
            res = chk(board, [i, j, k])
            if res != -1:
                ans = min(ans, res)
            
print(ans)