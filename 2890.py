import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

R, C = map(int, input().rstrip().split())
S = []
for _ in range(R):
    S.append(input().rstrip())

t = {}

for s in S:
    for i, v in enumerate(s):
        if str.isdigit(v):
            if i not in t:
                t[i] = list()
            t[i].append(v)
            break

ans = {}
rank = 1
for i in range(49, -1, -1):
    if i in t:
        for j in t[i]:
            ans[j] = rank
        rank += 1

for i in range(1, 10):
    print(ans[str(i)])