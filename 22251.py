import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, K, P, X = map(int, input().split())
ans = 0

table = [
    [0, 4, 3, 3, 4, 3, 2, 3, 1, 2], # 0
    [4, 0, 5, 3, 2, 5, 6, 1, 5, 4], # 1
    [3, 5, 0, 2, 5, 4, 3, 4, 2, 3], # 2
    [3, 3, 2, 0, 3, 2, 3, 2, 2, 1], # 3
    [4, 2, 5, 3, 0, 3, 4, 3, 3, 2], # 4
    [3, 5, 4, 2, 3, 0, 1, 4, 2, 1], # 5
    [2, 6, 3, 3, 4, 1, 0, 5, 1, 2], # 6
    [3, 1, 4, 2, 3, 4, 5, 0, 4, 3], # 7
    [1, 5, 2, 2, 3, 2, 1, 4, 0, 1], # 8
    [2, 4, 3, 1, 2, 1, 2, 3, 1, 0]  # 9
]

def cal(l):
    ret = 0
    a = '0'*(K-len(str(X))) + str(X) # current
    b = '0'*(K-len(str(N))) + str(N) # max
    for i in range(K):
        for j in range(int(b[i]) + 1):
            if table[int(a[i])][j] <= l[i] and table[int(a[i])][j] != 0:
                print(f'value = {table[int(a[i])][j]} idx = {j}')
                ret += 1

    return ret

def solve(n, l, depth):
    global ans
    if n < 0:
        return
    if n == 0:
        tmp = cal(l)
        print(tmp, l)
        ans += tmp
        return
    if depth == K:
        return

    for i in range(n+1):
        l[depth] = i
        solve(n-i, l, depth+1)
        l[depth] = 0

l = [0]*K
solve(P, l, 0)


print(ans)