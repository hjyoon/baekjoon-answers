import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools

def powerset(iterable):
    s = list(iterable)
    return itertools.chain.from_iterable(itertools.combinations(s, r) for r in range(len(s) + 1))

C, B = map(int, input().rstrip().split())
N = list(map(int, input().rstrip().split()))

ans = 0
for v in powerset(N):
    v = sum(v)
    if v <= C:
        ans = max(ans, v)
print(ans)