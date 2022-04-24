import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

board = [list(map(int, input().split())) for _ in range(3)]

cases = [
    [(0,0),(0,1),(0,2)],
    [(1,0),(1,1),(1,2)],
    [(2,0),(2,1),(2,2)],
    [(0,0),(1,0),(2,0)],
    [(0,1),(1,1),(2,1)],
    [(0,2),(1,2),(2,2)],
    [(0,0),(1,1),(2,2)],
    [(0,2),(1,1),(2,0)],
]

cases_p = {
    (0,0):[0,3,6],
    (0,1):[0,4],
    (0,2):[0,5,7],
    (1,0):[1,3],
    (1,1):[1,4,6,7],
    (1,2):[1,5],
    (2,0):[2,3,7],
    (2,1):[2,4],
    (2,2):[2,5,6],
}

def chk_33(board, y, x):
    for case in cases:
        base = board[y][x]
        l = map(lambda v:board[v[0]][v[1]]==base, case)
        if all(l):
            return base
    return None

def chk_22(board, y, x):
    cnt = 0
    for i in cases_p[(y, x)]:
        case = cases[i]
        base = board[y][x]
        l = map(lambda v:board[v[0]][v[1]]==base, case)
        l2 = map(lambda v:board[v[0]][v[1]]==0, case)
        if sum(l) == 2 and sum(l2) == 1:
            cnt += 1
            if cnt == 2:
                return base
    return None

def chk_222(board, my_turn, other_turn, y, x):
    cnt = 0
    cnt2 = 0
    for i in cases_p[(y, x)]:
        case = cases[i]
        l = map(lambda v:board[v[0]][v[1]]==my_turn, case)
        l2 = map(lambda v:board[v[0]][v[1]]==0, case)
        l3 = map(lambda v:board[v[0]][v[1]]==other_turn, case)
        if sum(l3) == 1 and sum(l2) == 1:
            cnt2 += 1
        if sum(l) == 2 and sum(l2) == 1:
            cnt += 1
        if cnt >= 2 and cnt2 >= 1:
            return my_turn
    return None

def chk_2(board, my_turn, y, x):
    for i in cases_p[(y, x)]:
        case = cases[i]
        l = map(lambda v:board[v[0]][v[1]]==my_turn, case)
        l2 = map(lambda v:board[v[0]][v[1]]==0, case)
        if sum(l) == 2 and sum(l2) == 1:
            return True
        
def find_33_pos(board, turn):
    for i in range(3):
        for j in range(3):
            if board[i][j] == 0:
                board[i][j] = turn
                if chk_33(board, i, j) == turn:
                    return i, j
                board[i][j] = 0
                    
def find_22_pos(board, turn):
    res = []
    for i in range(3):
        for j in range(3):
            if board[i][j] == 0:
                board[i][j] = turn
                if chk_22(board, i, j) == turn:
                    res.append((i, j))
                board[i][j] = 0
                
    return res
                    
def find_222_pos(board, turn, other_turn):
    for i in range(3):
        for j in range(3):
            if board[i][j] == 0:
                board[i][j] = turn
                if chk_222(board, turn, other_turn, i, j) == turn:
                    return i, j
                board[i][j] = 0
                    
def find_potential_22_pos(board, turn):
    for i in range(3):
        for j in range(3):
            if board[i][j] == 0:
                board[i][j] = turn
                res = find_22_pos(board, turn)
                if len(res) >= 2:
                    return i, j
                board[i][j] = 0
            
def find_potential_22_and_attack_pos(board, turn):
    for i in range(3):
        for j in range(3):
            if board[i][j] == 0:
                board[i][j] = turn
                res = find_22_pos(board, turn)
                if len(res) >= 2 and chk_2(board, turn, i, j):
                    return i, j
                board[i][j] = 0
                
def find_2_pos(board, turn):
    for i in range(3):
        for j in range(3):
            if board[i][j] == 0:
                board[i][j] = turn
                if chk_2(board, turn, i, j):
                    return i, j
                board[i][j] = 0
                
def get_turn(board):
    cnt_1, cnt_2 = 0, 0
    for i in range(3):
        for j in range(3):
            if board[i][j] == 1:
                cnt_1 += 1
            elif board[i][j] == 2:
                cnt_2 += 1
            else:
                pass
    if cnt_1 == cnt_2:
        return 1, 2
    elif cnt_1 > cnt_2:
        return 2, 1
    else:
        return None

def is_draw(board):
    for i in range(3):
        for j in range(3):
            if board[i][j] == 0:
                return False
    return True
    
my_turn, other_turn = get_turn(board)
first = my_turn
while True:
    print(*board, sep='\n')
    print()
    # 내가 3을 만들 수 있는 자리 놓기
    res = find_33_pos(board, my_turn)
    if res:
        print('내가 3을 만들 수 있는 자리 놓기')
        if my_turn == first:
            print('W')
        else:
            print('L')
        board[res[0]][res[1]] = my_turn
        break
    
    # 상대의 3 자리 막기
    res = find_33_pos(board, other_turn)
    if res:
        print('상대의 3 자리 막기')
        board[res[0]][res[1]] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    
    # 내가 22를 만들 수 있는 자리 놓기
    res = find_22_pos(board, my_turn)
    if res:
        print('내가 22를 만들 수 있는 자리 놓기')
        board[res[0][0]][res[0][1]] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    
    # 상대의 22 자리 막기 + 내가 2를 만드는 자리
    res = find_222_pos(board, other_turn, my_turn)
    if res:
        print('상대의 22 자리 막기 + 내가 2를 만드는 자리')
        board[res[0]][res[1]] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    
    # 상대의 22 자리 막기
    res = find_22_pos(board, other_turn)
    if res:
        print('상대의 22 자리 막기')
        board[res[0][0]][res[0][1]] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    
    # 내가 잠재적 22를 만들 수 있는 자리 놓기 + 2 만들기
    res = find_potential_22_and_attack_pos(board, my_turn)
    if res:
        print('내가 잠재적 22를 만들 수 있는 자리 놓기 + 2 만들기')
        board[res[0]][res[1]] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    
    
    # 내가 잠재적 22를 만들 수 있는 자리 놓기
    res = find_potential_22_pos(board, my_turn)
    if res:
        print('내가 잠재적 22를 만들 수 있는 자리 놓기')
        board[res[0]][res[1]] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    
    # 내가 2 만들 수 있는 자리 놓기
    res = find_2_pos(board, my_turn)
    if res:
        print('내가 2 만들 수 있는 자리 놓기')
        board[res[0]][res[1]] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    
    # 가운데 비어있다면 놓기
    if board[1][1] == 0:
        #print('가운데 비어있다면 놓기')
        board[1][1] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    
    # 모서리 비어있다면 놓기
    if board[0][0] == 0:
        board[0][0] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    elif board[0][2] == 0:
        board[0][2] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    elif board[2][0] == 0:
        board[2][0] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    elif board[2][2] == 0:
        board[2][2] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    
    # 나머지 비어있다면 놓기
    if board[0][1] == 0:
        board[0][1] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    elif board[1][0] == 0:
        board[1][0] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    elif board[1][2] == 0:
        board[1][2] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
    elif board[2][1] == 0:
        board[2][1] = my_turn
        my_turn, other_turn = other_turn, my_turn
        continue
        
    if is_draw(board):
        print('D')
        break