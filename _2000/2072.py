import sys
from pprint import pprint
sys.stdin = open('input.txt')
input = sys.stdin.readline


def chk(dy, dx, y, x, color, board, n):
    if board[y][x] == color and n < 5:
        return chk(dy, dx, y+dy, x+dx, color, board, n+1)
    else:
        return n


def aggre_cnt(y, x, color, board):
    d_pos_list = (
        ((-1, 0), (1, 0)),
        ((0, -1), (0, 1)),
        ((-1, -1), (1, 1)),
        ((-1, 1), (1, -1)),
    )
    for d1, d2 in d_pos_list:
        cnt1 = chk(d1[0], d1[1], y, x, color, board, 0)
        cnt2 = chk(d2[0], d2[1], y, x, color, board, 0)
        if cnt1 + cnt2 - 1 == 5:
            return True
    return False


N = int(input())
board = [[9]*21] + [[9] + [0]*19 + [9] for _ in range(19)] + [[9]*21]
ans = -1
for i in range(1, N+1):
    y, x = map(int, input().split())
    if i % 2:
        color = 1
    else:
        color = 2
    board[y][x] = color

    if aggre_cnt(y, x, color, board):
        ans = i
        break

print(*board, sep='\n')
print(ans)
