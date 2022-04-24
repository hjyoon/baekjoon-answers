import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools

s = list(input().rstrip())
x = int(''.join(s))

ans = float('inf')
for v in itertools.permutations(s):
    v = int(''.join(v))
    if v > x:
        ans = min(ans, v)

print([ans, 0][ans == float('inf')])