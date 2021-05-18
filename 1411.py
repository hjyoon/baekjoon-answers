import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(lambda x:x.rstrip(), sys.stdin)

import itertools

ans = 0

for v in itertools.combinations(S, 2):
    if len(v[0]) != len(v[1]):
        continue
    d = {}
    chk = {}
    for w in zip(v[0], v[1]):
        if chk.get(w[1], False) == False:
            if d.get(w[0], None) == None:
                d[w[0]] = w[1]
                chk[w[1]] = True
            else:
                break
        else:
            if d.get(w[0], None) == w[1]:
                continue
            else:
                break
    else:
        #print(d, chk, v)
        ans += 1

print(ans)