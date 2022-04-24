import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input())

info = {}

S = map(lambda x: x.split(), sys.stdin)
S = list(map(lambda x: (int(x[0]), int(x[1])), S))

for i in range(len(S)):
    for j in range(len(S)):
        if i != j:
            a, b = S[i]
            c, d = S[j]
            if (a > c and b < d) or (a < c and b > d):
                info.setdefault((a, b), set()).add((c, d))
                info.setdefault((c, d), set()).add((a, b))

print(info)

ans = 0

while True:
    target = None
    max_len = 0
    for k, v in info.items():
        if max_len < len(v):
            max_len = len(v)
            target = k

    if not target:
        break

    for k in info[target]:
        info[k].discard(target)

    info.pop(target)
    ans += 1

print(ans)
