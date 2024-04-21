import sys
input = sys.stdin.readline

N = int(input())

S = []
for _ in range(N):
    s, e = map(int, input().split())
    S.append((s, 1))
    S.append((e, -1))

S.sort(key=lambda x: (x[0], x[1]))

ans = 0
current = 0
for _, w in S:
    current += w
    ans = max(ans, current)

print(ans)
