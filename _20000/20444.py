import sys
from pprint import pprint
sys.setrecursionlimit(10**9)
sys.stdin = open('input.txt')
input = sys.stdin.readline


N, K = map(int, input().split())
r, c = 0, 0
cnt = 0
while True:
    if cnt % 1000 == 0:
        print(r, c, cnt, (r+1) * (c+1))
    if (r+1) * (c+1) > K:
        ans = 'NO'
        break
    if cnt == N:
        if (r+1) * (c+1) == K:
            ans = 'YES'
            break

    if r > c:
        c += 1
    else:
        r += 1
    cnt += 1

print(ans)
