import sys
sys.stdin = open("input.txt", 'r')

_, *X = map(lambda x: x.rstrip(), sys.stdin)

import itertools

res = []
for i in X:
    # tmp = sorted(itertools.groupby(sorted(i.split())), key=lambda x:(len(list(x[1])), x[0]), reverse=True)[0:2]
    tmp = itertools.groupby(sorted(i.split(), reverse=True))
    tmp = sorted(map(lambda x:(int(x[0]), len(list(x[1]))), tmp), key=lambda x:(x[1], x[0]), reverse=True)[:2]
    if tmp[0][1] == 4:
        res.append(tmp[0][0]*5000+50000)
    elif tmp[0][1] == 3:
        res.append(tmp[0][0]*1000+10000)
    elif tmp[0][1] == 2 and tmp[1][1] == 2:
        res.append(tmp[0][0]*500+tmp[1][0]*500+2000)
    elif tmp[0][1] == 2:
        res.append(tmp[0][0]*100+1000)
    else:
        res.append(tmp[0][0]*100)

print(max(res))