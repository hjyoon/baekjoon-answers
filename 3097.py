import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import math

N = int(input().rstrip())
S = []
for _ in range(N):
    S.append(list(map(int, input().rstrip().split())))

ox = 0
oy = 0
for x, y in S:
    ox += x
    oy += y

print(ox, oy)
ans = float('inf')

for t in range(N):
    sx = 0
    sy = 0
    for i, v in enumerate(S):
        if i == t:
            continue
        sx += v[0]
        sy += v[1]
    #print(0, 0, sx, sy)
    ans = min(ans, math.dist((0, 0), (sx, sy)))
    #print(math.dist((0, 0), (sx, sy)))

print(f'{ans:.2f}')