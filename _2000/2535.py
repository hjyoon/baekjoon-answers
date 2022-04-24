import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections

_, *S = map(lambda x:x.rstrip(), sys.stdin)
S = map(lambda x:tuple(map(int, x.split())), S)
S = sorted(S, key=lambda x:x[2], reverse=True)
res = collections.OrderedDict()
cnt = 0

for v in S:
    ci, i, score = v
    if len(res.setdefault(ci, [])) < 2:
        res[ci].append(i)
        cnt += 1
        if cnt == 3:
            break

for ci, i in res.items():
    for v in i:
        print(f'{ci} {v}')