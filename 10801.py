import sys
sys.stdin = open("input.txt", 'r')

def check(x):
    if x[0] > x[1]:
        return 'A'
    elif x[0] < x[1]:
        return 'B'
    else:
        return 'D'

A, B = map(lambda x: x.rstrip(), sys.stdin)
res = zip(map(int, A.split()), map(int, B.split()))
res = sorted(map(check, res))

import collections

res = collections.Counter(res)

# import itertools
# res = dict(map(lambda x: (x[0], len(list(x[1]))), itertools.groupby(res)))
# res.setdefault('A', 0)
# res.setdefault('B', 0)
# res.setdefault('D', 0)
# print(res)

if res['A'] > res['B']:
    print('A')
elif res['A'] < res['B']:
    print('B')
else:
    print('D')