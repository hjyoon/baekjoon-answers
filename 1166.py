import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, L, W, H = map(int, input().rstrip().split())
left = 0
right = max(L, W, H)
mid = 0

def chk():
    if N > (L//mid)*(W//mid)*(H//mid):
        return True
    else:
        return False

for _ in range(10000):
    mid = (left + right) / 2
    if chk():
        right = mid
    else :
        left = mid

print(f'{mid:.9f}')