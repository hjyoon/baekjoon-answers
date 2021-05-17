import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(lambda x:x.rstrip(), sys.stdin)
R, C = map(int, _.split())

ans = []

def srch(i, j, b):
    r = []
    if b: # 세로로 검색
        pos = i
        while True:
            r.append(S[pos][j])
            pos += 1
            if pos == R or S[pos][j] == '#':
                break
    else: # 가로로 검색
        pos = j
        while True:
            r.append(S[i][pos])
            pos += 1
            if pos == C or S[i][pos] == '#':
                break
    r = ''.join(r)
    if len(r) > 1:
        return r
    else:
        return ''


def sol(i, j):
    if S[i][j] == '#':
        return

    if i == 0 or S[i-1][j] == '#': # 세로로 검색
        tmp = srch(i, j, True)
        if tmp != '':
            ans.append(tmp)

    if j == 0 or S[i][j-1] == '#': # 가로로 검색
        tmp = srch(i, j, False)
        if tmp != '':
            ans.append(tmp)

for i in range(R):
    for j in range(C):
        sol(i, j)

ans.sort()

print(ans[0])