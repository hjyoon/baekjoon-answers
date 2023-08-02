import sys
input = sys.stdin.readline

N = int(input())

size = [(1, 1), (3, 5), (7, 13), (15, 29), (31, 61), (63, 125),
        (127, 253), (255, 509), (511, 1021), (1023, 2045)]

R, C = size[N-1]

board = [[' ']*C for _ in range(R)]


def re(y1, x1, y2, x2, step):
    if step == 0:
        return

    _R, _C = size[step-1]
    if step % 2 == 0:
        for c in range(x1, x2+1):
            board[y1][c] = '*'
        for i in range(y2-y1+1):
            board[y1+i][x1+i] = '*'
        for i in range(y2-y1+1):
            board[y1+i][x2-i] = '*'
        re(y1+1, x1+(_R+1)//2, (y1+y2)//2, x2-(_R+1)//2, step-1)
    else:
        for c in range(x1, x2+1):
            board[y2][c] = '*'
        for i in range(y2-y1+1):
            board[y2-i][x1+i] = '*'
        for i in range(y2-y1+1):
            board[y2-i][x2-i] = '*'
        re((y1+y2)//2, x1+(_R+1)//2, y2-1, x2-(_R+1)//2, step-1)


re(0, 0, R-1, C-1, N)

for line in board:
    print(''.join(line).rstrip(), sep='')
