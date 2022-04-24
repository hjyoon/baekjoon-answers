import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, M = map(int, input().split())
S = sorted([[int(v) for v in input().split()]
           for _ in range(N)], key=lambda x: x[1])

ac_w = [0]*N
ac_p = [0]*N
ac_w[0] = S[0][0]
ac_p[0] = S[0][1]
for i in range(1, len(S)):
    ac_w[i] = ac_w[i-1] + S[i][0]
    if S[i-1][1] == S[i][1]:
        ac_p[i] = ac_p[i-1] + S[i][1]
    else:
        ac_p[i] = S[i][1]

l = sorted(zip(ac_w, ac_p), key=lambda x: x[1])
print(l)

res = 0
for w, p in l:
    if w >= M:
        res = p
        break
print(res)


print(*S, sep='\n')
print(ac_w)
print(ac_p)

# idx = bisect.bisect_left(ac_w, M)
# print(S[idx][1])
