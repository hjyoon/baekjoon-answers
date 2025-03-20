import sys


def solve():
    input = sys.stdin.readline

    board = [None] * 10
    for i in range(1, 10):
        board[i] = tuple(map(lambda x: x[0], input().rstrip().split()))

    def chk(a, b, c):
        for i in range(3):
            if len({board[a][i], board[b][i], board[c][i]}) == 2:
                return False
        return True

    answers = {"e"}
    for i in range(1, 8):
        for j in range(i + 1, 9):
            for k in range(j + 1, 10):
                if chk(i, j, k):
                    answers.add(f"{i}{j}{k}")

    ans = 0
    N = int(input())
    for i in range(N):
        tmp = input().rstrip().split()
        if tmp[0] == "H":
            a, b, c = sorted(tmp[1:])
            if a + b + c in answers:
                answers.remove(a + b + c)
                ans += 1
            else:
                ans -= 1
        else:
            if "e" in answers and len(answers) == 1:
                answers.remove("e")
                ans += 3
            else:
                ans -= 1

    print(ans)


solve()
