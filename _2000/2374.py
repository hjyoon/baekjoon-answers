import sys
input = sys.stdin.readline

N = int(input())
S = [int(input()) for _ in range(N)]


def find_min_idx(S):
    l = len(S)
    min_value = float('inf')
    flag = 0
    start, end = -1, -1
    for i in range(l):
        if min_value > S[i]:
            min_value = S[i]
            flag = 1
            start = i
            end = i
        elif flag == 1 and min_value == S[i]:
            end = i
        else:
            flag = 0
    return start, end


ans = 0
while True:
    start, end = find_min_idx(S)
    if start == 0 and end == N-1:
        break

    tmp = []
    if start-1 >= 0:
        tmp.append(S[start-1])
    if end+1 < N:
        tmp.append(S[end+1])

    tmp2 = min(tmp)
    ans += (tmp2 - S[start])
    for i in range(start, end+1):
        S[i] = tmp2

print(ans)
