import sys
from pprint import pprint
sys.stdin = open('input.txt')
input = sys.stdin.readline


def find_candidate(v, space):
    ret = -1
    for i in range(len(space)):
        if space[i][0] == v:
            ret = i
            break
    return ret


def find_lowest(space):
    ret = 0
    min_tmp = space[0][1]
    for i in range(len(space)-1, -1, -1):
        if space[i][1] <= min_tmp:
            ret = i
            min_tmp = space[i][1]
    return ret


N = int(input())
input()
S = map(int, input().split())
space = []
for v in S:
    idx = find_candidate(v, space)
    if idx != -1:  # 이미 게시 되어 있는 경우
        space[idx][1] += 1
    else:
        if len(space) >= N:  # 꽉 찬 경우
            del space[find_lowest(space)]
            space.append([v, 1])
        else:
            space.append([v, 1])

print(*sorted(map(lambda x: x[0], space)))
