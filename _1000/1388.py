from pprint import pprint
import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

# R, C = map(int, input().split())
# board = [input().rstrip() for _ in range(R)]
# visit = [[0]*C for _ in range(R)]


# def dfs(y, x, pre):
#     if y < 0 or x < 0 or y >= R or x >= C:
#         return

#     if visit[y][x] == 1:
#         return

#     if pre != board[y][x]:
#         return

#     visit[y][x] = 1
#     if board[y][x] == '-':
#         dfs(y, x+1, '-')
#     else:
#         dfs(y+1, x, '|')


# ans = 0
# for i in range(R):
#     for j in range(C):
#         if visit[i][j] == 0:
#             dfs(i, j, board[i][j])
#             ans += 1

# print(ans)

N, M = map(int, input().split())
arr = [list(map(str, input())) for _ in range(N)]
cnt = 0
stack = []
sta = []
for i in range(N):
    for j in range(M):
        if arr[i][j] == '-':
            stack.append(arr[i][j])

        elif len(stack) != 0 and arr[i][j] != '-':
            stack = []
            cnt += 1

    if len(stack) != 0:
        stack = []
        cnt += 1

for i in range(N):
    for j in range(M):
        if arr[j][i] == '|':
            sta.append(arr[j][i])
        elif len(sta) != 0 and arr[j][i] != '|':
            sta = []
            cnt += 1
    if len(sta) != 0:
        sta = []
        cnt += 1

print(cnt)
