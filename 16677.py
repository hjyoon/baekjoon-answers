import sys
input = sys.stdin.readline

def cmp(src, w, g):
    i, j = 0, 0
    while True:
        if i == len(src): # 만들 수 있음
            return g/(len(w)-len(src))
        if j == len(w): # 만들 수 없음
            return float('-inf')
        if src[i] == w[j]:
            i += 1
            j += 1
        else:
            j += 1

S = input().rstrip()
N = int(input())
Dic = []
ans = None
max_value = float('-inf')
for i in range(N):
    w, g = input().rstrip().split() # 1 <= g <= 10,000
    g = int(g)
    ret = cmp(S, w, g)
    if max_value < ret:
        ans = w
        max_value = ret

if ans:
    print(ans)
else:
    print('No Jam')