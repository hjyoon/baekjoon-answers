import sys


def solve():
    input = sys.stdin.readline
    N, M, x, y, K = map(int, input().rstrip().split())
    board = [list(map(int, input().rstrip().split())) for _ in range(N)]

    #   1
    # 3 0 2 (0 -> top, 2 -> east)
    #   4
    #   5
    #
    # move east [0, 1, 2, 3, 4, 5] -> [3, 1, 0, 5, 4, 2]
    # move west [0, 1, 2, 3, 4, 5] -> [2, 1, 5, 0, 4, 3]
    # move north [0, 1, 2, 3, 4, 5] -> [4, 0, 2, 3, 5, 1]
    # move south [0, 1, 2, 3, 4, 5] -> [1, 5, 2, 3, 0, 4]

    dice = [0] * 6

    def move(direction):
        if direction == 1:
            tmp = dice[2]
            dice[2] = dice[0]
            dice[0] = dice[3]
            dice[3] = dice[5]
            dice[5] = tmp
        elif direction == 2:
            tmp = dice[3]
            dice[3] = dice[0]
            dice[0] = dice[2]
            dice[2] = dice[5]
            dice[5] = tmp
        elif direction == 3:
            tmp = dice[1]
            dice[1] = dice[0]
            dice[0] = dice[4]
            dice[4] = dice[5]
            dice[5] = tmp
        else:
            tmp = dice[4]
            dice[4] = dice[0]
            dice[0] = dice[1]
            dice[1] = dice[5]
            dice[5] = tmp

    ans = []
    commands = map(int, input().rstrip().split())
    for command in commands:
        if command == 4:
            if x + 1 < N:
                x += 1
            else:
                continue
        elif command == 3:
            if x - 1 >= 0:
                x -= 1
            else:
                continue
        elif command == 2:
            if y - 1 >= 0:
                y -= 1
            else:
                continue
        else:
            if y + 1 < M:
                y += 1
            else:
                continue
        move(command)
        ans.append(dice[0])
        if board[x][y] == 0:
            board[x][y] = dice[5]
        else:
            dice[5] = board[x][y]
            board[x][y] = 0
    print(*ans, sep="\n")


solve()
