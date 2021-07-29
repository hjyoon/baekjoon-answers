import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

board = [list(map(int, input().split())) for _ in range(19)]
#print(*board, sep='\n')

# 7개 검사
horizontal_7 = [(0,0),(0,1),(0,2),(0,3),(0,4),(0,5),(0,6)]
vertical_7 = [(0,0),(1,0),(2,0),(3,0),(4,0),(5,0),(6,0)]
diagonal_7 = [(0,0),(1,1),(2,2),(3,3),(4,4),(5,5),(6,6)]
diagonal_re_7 = [(0,0),(1,-1),(2,-2),(3,-3),(4,-4),(5,-5),(6,-6)]

# 6개 검사
horizontal_6 = [(0,0),(0,1),(0,2),(0,3),(0,4),(0,5)]
vertical_6 = [(0,0),(1,0),(2,0),(3,0),(4,0),(5,0)]
diagonal_6 = [(0,0),(1,1),(2,2),(3,3),(4,4),(5,5)]
diagonal_re_6 = [(0,0),(1,-1),(2,-2),(3,-3),(4,-4),(5,-5)]

# 5개 검사
diagonal_5 = [(0,0),(1,1),(2,2),(3,3),(4,4)]
diagonal_re_5 = [(0,0),(1,-1),(2,-2),(3,-3),(4,-4)]

def chk_horizontal_7(y, x, color):
    other_color = 3-color
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(horizontal_7):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if idx == 0 or idx == len(horizontal_7)-1: # 양 끝 검사
            if board[tmpy][tmpx] == other_color or board[tmpy][tmpx] == 0: # 다른 돌로 막혀있거나, 비어있을 경우
                continue
            else:
                break
        else:
            if board[tmpy][tmpx] == color:
                continue
            else:
                break
    else:
        return color, (y, x+1)
    return None

def chk_vertical_7(y, x, color):
    other_color = 3-color
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(vertical_7):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if idx == 0 or idx == len(vertical_7)-1: # 양 끝 검사
            if board[tmpy][tmpx] == other_color or board[tmpy][tmpx] == 0: # 다른 돌로 막혀있거나, 비어있을 경우
                continue
            else:
                break
        else:
            if board[tmpy][tmpx] == color:
                continue
            else:
                break
    else:
        return color, (y+1, x)
    return None

def chk_diagonal_7(y, x, color):
    other_color = 3-color
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(diagonal_7):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if idx == 0 or idx == len(diagonal_7)-1: # 양 끝 검사
            if board[tmpy][tmpx] == other_color or board[tmpy][tmpx] == 0: # 다른 돌로 막혀있거나, 비어있을 경우
                continue
            else:
                break
        else:
            if board[tmpy][tmpx] == color:
                continue
            else:
                break
    else:
        return color, (y+1, x+1)
    return None

def chk_diagonal_re_7(y, x, color):
    other_color = 3-color
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(diagonal_re_7):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if idx == 0 or idx == len(diagonal_re_7)-1: # 양 끝 검사
            if board[tmpy][tmpx] == other_color or board[tmpy][tmpx] == 0: # 다른 돌로 막혀있거나, 비어있을 경우
                continue
            else:
                break
        else:
            if board[tmpy][tmpx] == color:
                continue
            else:
                break
    else:
        return color, (y+5, x-5)
    return None

def chk_horizontal_start_6(y, x, color):
    other_color = 3-color
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(horizontal_6):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if idx == len(horizontal_6)-1:
            if board[tmpy][tmpx] == other_color or board[tmpy][tmpx] == 0: # 다른 돌로 막혀있거나, 비어있을 경우
                continue
            else:
                break
        else:
            if board[tmpy][tmpx] == color:
                continue
            else:
                break
    else:
        return color, (y, x)
    return None

def chk_horizontal_end_6(y, x, color):
    other_color = 3-color
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(horizontal_6):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if idx == 0:
            if board[tmpy][tmpx] == other_color or board[tmpy][tmpx] == 0: # 다른 돌로 막혀있거나, 비어있을 경우
                continue
            else:
                break
        else:
            if board[tmpy][tmpx] == color:
                continue
            else:
                break
    else:
        return color, (y, x+1)
    return None

def chk_vertical_start_6(y, x, color):
    other_color = 3-color
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(vertical_6):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if idx == len(vertical_6)-1:
            if board[tmpy][tmpx] == other_color or board[tmpy][tmpx] == 0: # 다른 돌로 막혀있거나, 비어있을 경우
                continue
            else:
                break
        else:
            if board[tmpy][tmpx] == color:
                continue
            else:
                break
    else:
        return color, (y, x)
    return None

def chk_vertical_end_6(y, x, color):
    other_color = 3-color
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(vertical_6):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if idx == 0:
            if board[tmpy][tmpx] == other_color or board[tmpy][tmpx] == 0: # 다른 돌로 막혀있거나, 비어있을 경우
                continue
            else:
                break
        else:
            if board[tmpy][tmpx] == color:
                continue
            else:
                break
    else:
        return color, (y+1, x)
    return None

def chk_diagonal_start_6(y, x, color):
    other_color = 3-color
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(diagonal_6):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if idx == len(diagonal_6)-1:
            if board[tmpy][tmpx] == other_color or board[tmpy][tmpx] == 0: # 다른 돌로 막혀있거나, 비어있을 경우
                continue
            else:
                break
        else:
            if board[tmpy][tmpx] == color:
                continue
            else:
                break
    else:
        return color, (y, x)
    return None

def chk_diagonal_end_6(y, x, color):
    other_color = 3-color
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(diagonal_6):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if idx == 0:
            if board[tmpy][tmpx] == other_color or board[tmpy][tmpx] == 0: # 다른 돌로 막혀있거나, 비어있을 경우
                continue
            else:
                break
        else:
            if board[tmpy][tmpx] == color:
                continue
            else:
                break
    else:
        return color, (y+1, x+1)
    return None

def chk_diagonal_re_start_6(y, x, color):
    other_color = 3-color
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(diagonal_re_6):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if idx == len(diagonal_re_6)-1:
            if board[tmpy][tmpx] == other_color or board[tmpy][tmpx] == 0: # 다른 돌로 막혀있거나, 비어있을 경우
                continue
            else:
                break
        else:
            if board[tmpy][tmpx] == color:
                continue
            else:
                break
    else:
        return color, (y+4, x-4)
    return None

def chk_diagonal_re_end_6(y, x, color):
    other_color = 3-color
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(diagonal_re_6):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if idx == 0:
            if board[tmpy][tmpx] == other_color or board[tmpy][tmpx] == 0: # 다른 돌로 막혀있거나, 비어있을 경우
                continue
            else:
                break
        else:
            if board[tmpy][tmpx] == color:
                continue
            else:
                break
    else:
        return color, (y+5, x-5)
    return None

def chk_diagonal_5(y, x, color):
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(diagonal_5):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if board[tmpy][tmpx] == color:
            continue
        else:
            break
    else:
        return color, (y, x)
    return None

def chk_diagonal_re_5(y, x, color):
    #print(f'y={y}, x={x}')
    for idx, case in enumerate(diagonal_re_5):
        tmpy = y + case[0]
        tmpx = x + case[1]
        #if y == 0 and x == 0:
        #print(f'idx={idx}, tmpy={tmpy}, tmpx={tmpx}, color={board[tmpy][tmpx]}')
        if 0 <= tmpy < 19 and 0 <= tmpx < 19:
            pass
        else:
            break

        if board[tmpy][tmpx] == color:
            continue
        else:
            break
    else:
        return color, (y+4, x-4)
    return None

for i in range(19):
    for j in range(19):

        if j <= 12:
            res = chk_horizontal_7(i, j, 1) or chk_horizontal_7(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
        if i <= 12:
            res = chk_vertical_7(i, j, 1) or chk_vertical_7(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
        if i <= 12 and j <= 12:
            res = chk_diagonal_7(i, j, 1) or chk_diagonal_7(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
        if i <= 12 and j >= 6:
            res = chk_diagonal_re_7(i, j, 1) or chk_diagonal_re_7(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
        if j == 0:
            res = chk_horizontal_start_6(i, j, 1) or chk_horizontal_start_6(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
        if j == 13:
            res = chk_horizontal_end_6(i, j, 1) or chk_horizontal_end_6(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
        if i == 0:
            res = chk_vertical_start_6(i, j, 1) or chk_vertical_start_6(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
        if i == 13:
            res = chk_vertical_end_6(i, j, 1) or chk_vertical_end_6(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
        if i == 0 or j == 0:
            res = chk_diagonal_start_6(i, j, 1) or chk_diagonal_start_6(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
        if i == 13 or j == 13:
            res = chk_diagonal_end_6(i, j, 1) or chk_diagonal_end_6(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
        if i == 0 or j == 18:
            res = chk_diagonal_re_start_6(i, j, 1) or chk_diagonal_re_start_6(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
        if i == 13 or j == 5:
            res = chk_diagonal_re_end_6(i, j, 1) or chk_diagonal_re_end_6(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
        if (i == 0 and j == 14) or (i == 14 and j == 0):
            res = chk_diagonal_5(i, j, 1) or chk_diagonal_5(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
        if (i == 0 and j == 4) or (i == 14 and j == 18):
            res = chk_diagonal_re_5(i, j, 1) or chk_diagonal_re_5(i, j, 2)
            if res:
                print(res[0])
                print(f'{res[1][0]+1} {res[1][1]+1}')
                exit()
print(0)