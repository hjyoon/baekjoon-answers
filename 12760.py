import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(lambda x:x.rstrip(), sys.stdin)
N, M = map(int, _.split())

u = [0]*N
S = list(map(lambda x:x.split(), S))
for i, v in enumerate(S):
    S[i] = sorted(map(lambda x:(i, int(x)), v), reverse=True, key=lambda x:(x[1]))
S = list(zip(*S))
for i, v in enumerate(S):
    S[i] = sorted(v, reverse=True, key=lambda x:(x[1]))
for i, v in enumerate(S):
    S[i] = list(filter(lambda x:x[1]>=v[0][1], v))
for i, v in enumerate(S):
    S[i] = list(map(lambda x:x[0], v))
for v in S:
    for i in v:
        u[i] += 1
t = max(u)
for i, v in enumerate(u, 1):
    if v >= t:
        print(i, end=' ')