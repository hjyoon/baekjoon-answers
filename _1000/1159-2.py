import itertools
import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

N, *S = map(lambda x: x.rstrip(), sys.stdin)
S = sorted(map(lambda x: x[0], S))

ans = []
for v, it in itertools.groupby(S):
    if len(list(it)) >= 5:
        ans.append(v)
if not ans:
    print('PREDAJA')
else:
    print(*ans, sep='')
