import sys
sys.stdin = open("input.txt", 'r')

_, *c= map(lambda x: x.rstrip()[0], sys.stdin)

import collections

c = collections.Counter(c)
c = dict(filter(lambda x:x[1]>=5, c.items()))
c = sorted(map(lambda x:x, c.keys()))
if c:
    print(''.join(c))
else:
    print('PREDAJA')