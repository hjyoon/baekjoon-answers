import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = [s.rstrip().replace(' ', '') for s in sys.stdin]

d = {chr(i+ord('a')): 0 for i in range(26)}

for s in S:
    for c in s:
        d[c] += 1

l = sorted(d.items(), key=lambda x: x[1])

cnt = {}
for v in l:
    if v[1] not in cnt:
        cnt[v[1]] = []
    cnt[v[1]].append(v[0])

first = l[-1][1]
print(*cnt[first], sep='')
