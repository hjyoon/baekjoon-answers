import sys


def solve():
    input = sys.stdin.readline
    N, M = map(int, input().rstrip().split())
    board = [input().rstrip().split() for _ in range(N)]
    visited = [[-1] * M for _ in range(N)]
    sy, sx = -1, -1
    for i in range(N):
        for j in range(M):
            if board[i][j] == "0":
                visited[i][j] = 0
            elif board[i][j] == "2":
                sy, sx = i, j

    dy = (0, 1, -1, 0)
    dx = (1, 0, 0, -1)
    q = [(sy, sx, 0)]
    while True:
        tmp = []
        for cy, cx, cstep in q:
            if visited[cy][cx] != -1:
                continue
            visited[cy][cx] = cstep
            for i in range(4):
                ny, nx = cy + dy[i], cx + dx[i]
                if ny < 0 or ny >= N:
                    continue
                if nx < 0 or nx >= M:
                    continue
                nstep = cstep + 1
                tmp.append((ny, nx, nstep))
        q = tmp
        if not q:
            break
    ans = [" ".join(map(str, l)) for l in visited]
    print(*ans, sep="\n")


solve()
