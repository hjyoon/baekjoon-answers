import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, K = map(int, input().split())
S = []
info = {}

for _ in range(N):
    tmp = tuple(map(int, input().split()))
    S.append(tmp)
    info[tmp[0]] = tmp[1:]

S.sort(key=lambda x: (x[1], x[2], x[3]), reverse=True)

rank = {}
cnt = 0
for v in S:
    cnt += 1
    tmp = v[1:]
    if tmp not in rank:
        rank[tmp] = cnt

print(rank[info[K]])
