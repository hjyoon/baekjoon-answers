import sys
sys.stdin = open("input.txt", 'r')

S = map(lambda x: x.rstrip().replace(' ', ''), sys.stdin)
S = ''.join(S)

import collections
S = collections.Counter(S)
S = list(map(lambda x:x, S.items()))
v = max(S, key=lambda x:x[1])[1]
S = filter(lambda x:x[1] >= v, S)
S = sorted(map(lambda x:x[0], S))
print(''.join(S))