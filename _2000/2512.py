import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())
S = list(map(int, input().rstrip().split()))
M = int(input().rstrip())

def chk(limit):
    global M
    t = 0
    for v in S:
        if v >= limit:
            t += limit
        else:
            t += v
        if t > M:
            return False
    return True

left = 1
right = max(S)
limit = 0

while True:
    limit = (left + right) // 2
    if left > right:
        break
    if chk(limit):
        left = limit + 1
    else:
        right = limit - 1

print(limit)