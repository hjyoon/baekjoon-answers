import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

T = int(input())

def chk(board, turn, y, x):
    cases = [
        [0,1,2],
        [3,4,5],
        [6,7,8],
        [0,3,6],
        [1,4,7],
        [2,5,8],
        [0,4,8],
        [2,4,6]
    ]
    for case in cases:
        for pos in case:
            y, x = pos//3, pos%3
            if board[y][x] != turn:
                break
        else:
            return True
    return False



for t in range(1, T+1):
    board = [list(input().rstrip()) for _ in range(3)]
    turn = input().rstrip()
    for i in range(9):
        y, x = i//3, i%3
        if board[y][x] == '-':
            board[y][x] = turn
            if chk(board, turn, y, x):
                print(f'Case {t}:')
                for line in board:
                    print(''.join(line))
            board[y][x] = '-'
                