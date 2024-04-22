import sys
input = sys.stdin.readline
read = sys.stdin.read


def cal(i, cur):
    ret = cur
    while i < len(S):
        l, r = S[i]
        if l <= cur and cur <= r:
            ret = max(ret, r)
            i += 1
        elif cur > r:
            i += 1
            continue
        else:
            break
    return i, ret


M = int(input())

S = []
while True:
    l, r = map(int, input().split())
    if l == 0 and r == 0:
        break
    if l <= 0 and r <= 0:
        continue
    elif l >= M and r >= M:
        continue
    if l < 0:
        l = 0
    if r > M:
        r = M
    S.append((l, r))

S.sort(key=lambda x: (x[0], x[1]))

# print(S)

ans = 0
cur = 0
i = 0
while i < len(S):
    new_i, new_cur = cal(i, cur)
    # print(i, cur, new_i, new_cur)

    if new_cur > cur:
        ans += 1

    if new_i == i and new_cur == cur:
        print(0)
        exit(0)
    else:
        i = new_i
        cur = new_cur

if cur < M:
    print(0)
else:
    print(ans)
