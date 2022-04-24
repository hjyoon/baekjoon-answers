import sys
from pprint import pprint
sys.stdin = open('input.txt')
input = sys.stdin.readline


N, M = map(int, input().split())
S = tuple(map(lambda x: int(x)+1, input().split()))
l = []

tmp = M - sum(S)
if tmp > 0:
    for _ in range(N):
        l.append(tmp//N)
    for i in range(tmp % N):
        l[i] += 1
    ans = 0
    for v in l:
        ans += v**2
    # print(*l)
    print(ans)
else:
    print(0)
