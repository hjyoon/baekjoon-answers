import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools

N, K = map(int, input().rstrip().split())
S = map(int, input().rstrip().split())
ans = 0

for v in itertools.permutations(S):
    a = True
    t = 500
    for w in v:
        t += w
        t -= K
        if t < 500:
            a = False
            break
    if a == True:
        ans += 1
print(ans)