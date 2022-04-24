import sys
sys.setrecursionlimit(100000000)
sys.stdin = open("input.txt", 'r')

input = sys.stdin.readline

R, C = map(int, input().split())
S = [[int(i) for i in input().split()] for _ in range(R)]

dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]


def dfs(y, x):
    if 0 <= y < R and 0 <= x < C:
        if visit[y][x] == 0:
            if S[y][x] == 0:
                visit[y][x] = 1
                for i in range(4):
                    dfs(y+dy[i], x+dx[i])
            else:
                down[y][x] += 1


def cc(y, x):
    if 0 <= y < R and 0 <= x < C:
        if visit[y][x] == 0 and S[y][x] != 0:
            visit[y][x] = 1
            for i in range(4):
                dfs(y+dy[i], x+dx[i])


ans = 0
while True:
    visit = [[0]*C for _ in range(R)]
    down = [[0]*C for _ in range(R)]
    cnt = 0

    # O(NM)
    # 어느 부분이 녹을지 찾기
    for i in range(R):
        for j in range(C):
            if S[i][j] == 0:
                dfs(i, j)

    # O(NM)
    # 빙산 녹음
    for i in range(R):
        for j in range(C):
            S[i][j] = max(S[i][j]-down[i][j], 0)

    # O(NM)
    # 연결요소 개수가 2개인지 검사
    for i in range(R):
        for j in range(C):
            if visit[i][j] == 0 and S[i][j] != 0:
                cnt += 1
                cc(i, j)

    if cnt == 2:
        break

    # 녹을 빙산이 없는 경우
    done = 0
    for v in S:
        done += sum(v)
    if done == 0:
        break

    ans += 1

print(ans)
