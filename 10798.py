import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

import itertools
S = map(lambda x:x.rstrip(), sys.stdin)
S = itertools.zip_longest(*S, fillvalue='')
S = map(lambda x:''.join(x), S)
print(*S, sep='')