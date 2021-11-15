import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

# cases = [
#     [0,1,2], # 0
#     [3,4,5], # 1
#     [6,7,8], # 2
#     [0,3,6], # 3
#     [1,4,7], # 4
#     [2,5,8], # 5
#     [0,4,8], # 6
#     [2,4,6], # 7
# ]

# def check(board, pos):
#     base = board[pos[0]]
#     if all(map(lambda x:board[x] == base, pos)):
#         return base
    
# while True:
#     v = input().rstrip()
#     if v == 'end':
#         break
#     Xcnt, Ocnt = 0, 0
#     for c in v:
#         if c == 'X':
#             Xcnt += 1
#         elif c == 'O':
#             Ocnt += 1
#         else:
#             pass
    
#     x_bingo, o_bingo = 0, 0
#     for case in cases:
#         res = check(v, case)
#         if res == 'X':
#             x_bingo += 1
#         elif res == 'O':
#             o_bingo += 1
#         else:
#             pass
        
#     if Xcnt == Ocnt:
#         if o_bingo == 1 and x_bingo == 0:
#             print('vaild')
#         else:
#             print('invalid')
#     elif Xcnt == 5 and Ocnt == 4:
#         if o_bingo == 0 and x_bingo >= 0:
#             print('vaild')
#         else:
#             print('invalid')
#     elif Xcnt-1 == Ocnt:
#         if o_bingo == 0 and x_bingo > 0:
#             print('vaild')
#         else:
#             print('invalid')
#     else:
#         print('invalid')
        
def tictactoe():
    global winner, flag
    # 가로 시작점
    x_list = [(0, 0), (1, 0), (2, 0)]
    #세로 시작점
    y_list = [(0, 0), (0, 1), (0, 2)]
    #왼쪽 대각선 시작점
    xy_list = [(0, 0)]
    #오른쪽 대각선 시작점
    yx_list = [(0, 2)]

    #가로 빙고 서치
    for x, y in x_list:
        cur = ttt[x][y]
        if cur != '.':
            if ttt[x][y] == ttt[x][y+1] == ttt[x][y+2]:
                if winner != '.' and winner != cur:
                    flag = 1
                    return
                winner = cur

    #세로 빙고 서치
    for x, y in y_list:
        cur = ttt[x][y]
        if cur != '.':
            if ttt[x][y] == ttt[x+1][y] == ttt[x+2][y]:
                if winner != '.' and winner != cur:
                    flag = 1
                    return
                winner = cur

    #왼쪽 대각선 빙고 서치
    for x, y in xy_list:
        cur = ttt[x][y]
        if cur != '.':
            if ttt[x][y] == ttt[x+1][y+1] == ttt[x+2][y+2]:
                if winner != '.' and winner != cur:
                    flag = 1
                    return
                winner = cur

    #오른쪽 대각선 빙고 서치
    for x, y in yx_list:
        cur = ttt[x][y]
        if cur != '.':
            if ttt[x][y] == ttt[x+1][y-1] == ttt[x+2][y-2]:
                if winner != '.' and winner != cur:
                    flag = 1
                    return
                winner = cur


while True:
    inp = list(input().rstrip())
    if len(inp) < 9:
        break
    ttt = []
    ttt.append(inp[:3])
    ttt.append(inp[3:6])
    ttt.append(inp[6:])
    flag = 0

    # X가 O의 개수+1 보다 크면 invalid
    if inp.count('X') > inp.count('O') + 1:
        flag = 1
    # O 가 X 개수보다 많으면 invalid
    elif inp.count('X') < inp.count('O'):
        flag = 1
    else:
    # 위 두 조건을 통과하면 함수로 이긴 사람을 찾는다.
        winner = '.'
        tictactoe()
        # O가 이겼을 때는 항상 X와 O의 개수가 같아야 한다.
        if winner == 'O' and inp.count('X') != inp.count('O'):
            flag = 1
        # X가 이겼을 때는 X와 O의 개수가 같으면 안 된다.
        elif winner == 'X' and inp.count('X') <= inp.count('O'):
            flag = 1
        # 이긴 사람이 없을 때는 '.'이 남아있으면 안 된다. (꽉 찼을 때는 이긴 사람이 없어도 상관 없다.)
        if winner == '.':
            if inp.count('.'):
                flag = 1

    if flag == 0:
        print('valid')
    else:
        print('invalid')