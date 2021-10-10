import sys
from pprint import pprint
sys.stdin = open('input.txt')
input = sys.stdin.readline


# 12시 방향에 있는 S극의 개수 리턴
def cnt_S(gear):
    ret = 0
    for i in range(len(gear)):
        if gear[i][0] == '1':
            ret += 1
    return ret


def rotate_gear(l, direction):
    if direction == 1:  # 시계 방향으로 한 번 돌린다
        l.insert(0, l[-1])
        l.pop()
    elif direction == -1:  # 반시계 방향으로 한 번 돌린다
        l.append(l[0])
        del l[0]
    else:
        pass


def recursive_rotate_gear(gear, i, d, route=None):
    if i < 0 or i >= len(gear):
        return
    if route == None:
        rotate_gear(gear[i], d)
        recursive_rotate_gear(gear, i-1, [-1, 1][d == -1], 'left')
        recursive_rotate_gear(gear, i+1, [-1, 1][d == -1], 'right')
    elif route == 'left':
        if d == 1:
            if gear[i+1][5] != gear[i][2]:
                rotate_gear(gear[i], d)
                recursive_rotate_gear(gear, i-1, [1, -1][d == 1], route)
        elif d == -1:
            if gear[i+1][7] != gear[i][2]:
                rotate_gear(gear[i], d)
                recursive_rotate_gear(gear, i-1, [1, -1][d == 1], route)
    elif route == 'right':
        if d == 1:
            if gear[i-1][1] != gear[i][6]:
                rotate_gear(gear[i], d)
                recursive_rotate_gear(gear, i+1, [1, -1][d == 1], route)
        elif d == -1:
            if gear[i-1][3] != gear[i][6]:
                rotate_gear(gear[i], d)
                recursive_rotate_gear(gear, i+1, [1, -1][d == 1], route)
    else:
        pass


ans = None
N = int(input())

# 12시방향부터 시계방향 순서로 0(N) 또는 1(S)
gear = [list(input().rstrip()) for _ in range(N)]

K = int(input())
for _ in range(K):
    idx, d = map(int, input().split())
    idx -= 1
    recursive_rotate_gear(gear, idx, d)

ans = cnt_S(gear)
print(ans)
