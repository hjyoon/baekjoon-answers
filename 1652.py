import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input())
S = [input().rstrip() for _ in range(N)]

def solve(S):
    ret = 0
    for s in S:
        tmp = [-1]
        for i in range(N):
            if s[i] == 'X':
                tmp.append(i)
        tmp.append(N)
        for j in range(1, len(tmp)):
            if tmp[j] - tmp[j-1] > 2:
                ret += 1
    return ret

ans1 = solve(S)
ans2 = solve(zip(*S))

print(ans1, ans2)