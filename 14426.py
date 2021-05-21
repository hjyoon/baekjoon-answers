import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
S = [input().rstrip() for _ in range(N)]
T = [input().rstrip() for _ in range(M)]

S.sort()

import bisect

ans = 0

for v in T:
    pos = bisect.bisect_left(S, v)
    if pos < len(S) and v == S[pos][:len(v)]:
        ans += 1

print(ans)