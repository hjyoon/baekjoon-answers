import itertools
import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, K, P, X = map(int, input().split())
X = str(X)
X = '0'*(K-len(X)) + X
X = list(map(int, X))
ans = set()

table = [
    [0, 4, 3, 3, 4, 3, 2, 3, 1, 2],  # 0
    [4, 0, 5, 3, 2, 5, 6, 1, 5, 4],  # 1
    [3, 5, 0, 2, 5, 4, 3, 4, 2, 3],  # 2
    [3, 3, 2, 0, 3, 2, 3, 2, 2, 1],  # 3
    [4, 2, 5, 3, 0, 3, 4, 3, 3, 2],  # 4
    [3, 5, 4, 2, 3, 0, 1, 4, 2, 1],  # 5
    [2, 6, 3, 3, 4, 1, 0, 5, 1, 2],  # 6
    [3, 1, 4, 2, 3, 4, 5, 0, 4, 3],  # 7
    [1, 5, 2, 2, 3, 2, 1, 4, 0, 1],  # 8
    [2, 4, 3, 1, 2, 1, 2, 3, 1, 0]   # 9
]


def cal_ava(tmp):
    global ans
    # print(tmp)
    for v in itertools.product(*tmp):
        n = int(''.join(v))
        if n <= N:
            ans.add(n)
    return


def cal(l):
    tmp = []
    for i in range(K):
        tmp2 = []
        for j in range(10):
            if table[X[i]][j] <= l[i]:
                # tmp2.append(str(j))
                ...
        # tmp.append(tmp2)
    # cal_ava(tmp)
    return


def solve(n, l, depth):
    if n < 0:
        return
    if n == 0:
        # print(l)
        # cal(l)
        tmp = []
        for i in range(K):
            tmp2 = []
            for j in range(10):
                if table[X[i]][j] <= l[i]:
                    tmp2.append(str(j))
            tmp.append(tmp2)
        for v in itertools.product(*tmp):
            m = int(''.join(v))
            if m <= N:
                ans.add(m)
        return
    if depth == K:
        return

    for i in range(n+1):
        l[depth] = i
        solve(n-i, l, depth+1)
        l[depth] = 0


l = [0]*K
solve(P, l, 0)

# print(ans)
print(len(ans)-1)
