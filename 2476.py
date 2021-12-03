import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

N = int(input())

res = 0
for i in range(N):
    S = sorted(map(int, input().split()))
    tmp = 0
    if S[0] == S[1] and S[0] == S[2]:
        tmp = 10000 + S[0]*1000
    elif S[0] == S[1]:
        tmp = 1000 + S[0]*100
    elif S[1] == S[2]:
        tmp = 1000 + S[1]*100
    else:
        tmp = S[2]*100
    res = max(res, tmp)
