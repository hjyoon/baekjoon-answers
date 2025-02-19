import sys
import collections

input = sys.stdin.readline


def solve():
    N, M = map(int, input().rstrip().split())
    board = [input() for _ in range(N)]
    visited = [[0] * M for _ in range(N)]
    sy, sx = -1, -1
    for i in range(N):
        for j in range(M):
            if board[i][j] == "I":
                sy, sx = i, j

    def bfs(y, x):
        q = collections.deque([(y, x)])
        ret = 0
        while q:
            cy, cx = q.popleft()
            if visited[cy][cx] == 1:
                continue
            visited[cy][cx] = 1
            if board[cy][cx] == "P":
                ret += 1
            for dy, dx in ((0, 1), (1, 0), (0, -1), (-1, 0)):
                ny, nx = cy + dy, cx + dx
                if ny < 0 or ny >= N:
                    continue
                if nx < 0 or nx >= M:
                    continue
                if board[ny][nx] == "X":
                    continue
                q.append((ny, nx))
        return ret

    ans = bfs(sy, sx)
    print(ans if ans != 0 else "TT")


solve()
