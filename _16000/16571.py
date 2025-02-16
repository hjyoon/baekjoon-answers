import sys

input = sys.stdin.readline


def solve():
    board = []
    for _ in range(3):
        board += input().rstrip().split()

    memo = {}

    def dp(turn):
        status = "".join(board)
        if status in memo:
            return memo[status]
        if board[0] == board[1] == board[2] != "0":
            return board[0]
        elif board[3] == board[4] == board[5] != "0":
            return board[3]
        elif board[6] == board[7] == board[8] != "0":
            return board[6]
        elif board[0] == board[3] == board[6] != "0":
            return board[0]
        elif board[1] == board[4] == board[7] != "0":
            return board[1]
        elif board[2] == board[5] == board[8] != "0":
            return board[2]
        elif board[0] == board[4] == board[8] != "0":
            return board[0]
        elif board[2] == board[4] == board[6] != "0":
            return board[2]
        res = []
        for i in range(len(board)):
            if board[i] == "0":
                board[i] = turn
                tmp = dp("1" if turn == "2" else "2")
                board[i] = "0"
                res.append(tmp)
        if turn in res:
            memo[status] = turn
            return turn
        elif 0 in res or not res:
            memo[status] = 0
            return 0
        else:
            memo[status] = "1" if turn == "2" else "2"
            return memo[status]

    turn = "2" if board.count("1") > board.count("2") else "1"
    ans = dp(turn)
    if ans == turn:
        print("W")
    elif ans == 0:
        print("D")
    else:
        print("L")


solve()
