import sys
from pprint import pprint
sys.stdin = open('input.txt')
input = sys.stdin.readline

N = int(input())
S = []

max_x = -1001
min_x = 1001
max_y = -1001
min_y = 1001

for _ in range(N):
    x, y = map(int, input().split())
    S.append((x, y))
    max_x = max(max_x, x)
    min_x = min(min_x, x)
    max_y = max(max_y, y)
    min_y = min(min_y, y)


side_len = None
is_x = False
side_x = abs(max_x-min_x)
side_y = abs(max_y-min_y)

if side_x > side_y:
    side_len = side_x
    is_x = True
else:
    side_len = side_y


def is_available(x1, y1, x2, y2, l):
    for x, y in l:
        if x == x1 or x == x2 or y == y1 or y == y2:
            continue
        else:
            return False
    else:
        return True


ans = -1
if is_x:
    if is_available(min_x, min_y, max_x, min_y+side_len, S) or is_available(min_x, max_y-side_len, max_x, max_y, S):
        ans = side_len
else:
    if is_available(min_x, min_y, min_x+side_len, max_y, S) or is_available(max_x-side_len, min_y, max_x, max_y, S):
        ans = side_len

print(ans)
