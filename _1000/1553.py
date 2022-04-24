import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

S = []
for _ in range(8):
    S.append(input().rstrip())

chk = [[0]*7 for _ in range(8)]

dominos = {}
for i in range(7):
    for j in range(i, 7):
        dominos[f'{i}{j}'] = 1


def get_need(y, x, place):
    if place == 0:
        if 0 <= y <= 7 and 0 <= x+1 <= 6:
            return min(S[y][x],S[y][x+1]) + max(S[y][x],S[y][x+1])
        else:
            return None
    else:
        if 0 <= y+1 <= 7 and 0 <= x <= 6:
            return min(S[y][x],S[y+1][x]) + max(S[y][x],S[y+1][x])
        else:
            return None

def chk_success():
    for v in chk:
        if 0 in v:
            return False
    return True

def onboard(y, x, place):
    chk[y][x] = 1
    if place == 0:
        chk[y][x+1] = 1
    else:
        chk[y+1][x] = 1

def offboard(y, x, place):
    chk[y][x] = 0
    if place == 0:
        chk[y][x+1] = 0
    else:
        chk[y+1][x] = 0

res = 0
def sol(y, x, place): # place == 0 : 가로, 1 : 세로
    global res
    print(*chk, sep='\n')
    print()
    w = get_need(y, x, place)
    if w == None:
        return
    
    if dominos[w] == 0:
        return
    else:
        dominos[w] = 0
        onboard(y, x, place)

        if chk_success():
            res += 1

        if place == 0:
            sol(y, x+2, 0)
            sol(y+1, x, 0)
            sol(y, x, 1)
        else:
            sol(y+2, x, 0)
            sol(y, x+1, 0)
        dominos[w] = 1
        offboard(y, x, place)

sol(0, 0, 0)
print(res)
# print(dominos)
print(*chk, sep='\n')
# print(*S, sep='\n')