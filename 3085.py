import sys
from pprint import pprint
sys.stdin = open('input.txt')
input = sys.stdin.readline


def cal_line(l):
    ret_max = 1
    tmp_cnt = 1
    i = 0
    tmp = None
    while i < len(l):
        if l[i] == tmp:
            tmp_cnt += 1
        else:
            tmp = l[i]
            ret_max = max(ret_max, tmp_cnt)
            tmp_cnt = 1
        i += 1
    ret_max = max(ret_max, tmp_cnt)
    return ret_max


def cal(n, s, y1, y2, x1, x2):
    ret = 0

    ret = max(ret, cal_line(s[y1]))  # 가로1
    if y2:
        ret = max(ret, cal_line(s[y2]))  # 가로2

    tmp = []
    for i in range(n):
        tmp.append(s[i][x1])
    ret = max(ret, cal_line(tmp))  # 세로1

    if x2:
        tmp = []
        for i in range(n):
            tmp.append(s[i][x2])
        ret = max(ret, cal_line(tmp))  # 세로2

    return ret


N = int(input())
S = [list(input().rstrip()) for _ in range(N)]
ans = 0
for i in range(N):
    for j in range(N):
        if j+1 < N:
            S[i][j], S[i][j+1] = S[i][j+1], S[i][j]
            ans = max(ans, cal(N, S, i, None, j, j+1))
            S[i][j], S[i][j+1] = S[i][j+1], S[i][j]

        if i+1 < N:
            S[i][j], S[i+1][j] = S[i+1][j], S[i][j]
            ans = max(ans, cal(N, S, i, i+1, j, None))
            S[i][j], S[i+1][j] = S[i+1][j], S[i][j]

print(ans)
