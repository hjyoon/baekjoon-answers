import sys
input = sys.stdin.readline

N = int(input())
S = [input().rstrip() for _ in range(N)]

S.sort(key=lambda x:(int(x)))

if len(S) >= 4:
    l = [S[0] + S[1], S[0] + S[2], S[0] + S[3], S[1] + S[0], S[2] + S[0], S[3] + S[0]]
else:
    l = [S[0] + S[1], S[0] + S[2], S[1] + S[0], S[2] + S[0], S[1] + S[2], S[2] + S[1]]

l.sort(key=lambda x:(int(x)))

print(l[2])