import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools

def sol(a, b, c):
    x1, y1 = a[0], a[1]
    x2, y2 = b[0], b[1]
    x3, y3 = c[0], c[1]
    return abs((x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3)) / 2

N = int(input().rstrip())
S = []
for _ in range(N):
    S.append(list(map(int, input().rstrip().split())))

ans = 0

for a, b, c in itertools.combinations(S, 3):
    t = sol(a, b, c)
    ans = max(ans, t)
    
print(ans)