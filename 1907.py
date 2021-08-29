import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline


def split_3_parts(S):
    tmp = []
    l = []
    for s in S:
        if s in '+=':
            l.append(tmp)
            tmp = []
        else:
            tmp.append(s)
    l.append(tmp)
    return l


def cal_mole(l):
    res = [[0]*3 for _ in range(3)]
    d2 = {'C': 0, 'H': 1, 'O': 2}
    for i in range(len(l)):
        l[i].append('X')
        for j in range(len(l[i])-1):
            a = l[i][j]
            b = l[i][j+1]
            if a.isalpha() and b.isalpha():
                res[i][d2[a]] += 1
            elif a.isalpha() and b.isdigit():
                res[i][d2[a]] += int(b)
            else:
                pass
    return res


def find_all_case(l):
    res = []
    for i in range(1, 11):
        for j in range(1, 11):
            for k in range(1, 11):
                if l[0][0]*i + l[1][0]*j == l[2][0]*k:
                    if l[0][1]*i + l[1][1]*j == l[2][1]*k:
                        if l[0][2]*i + l[1][2]*j == l[2][2]*k:
                            res.append([i, j, k])
    return res


S = input().rstrip()
l = split_3_parts(S)
l = cal_mole(l)
ans = find_all_case(l)

print(*ans[0])
