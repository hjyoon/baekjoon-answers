import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

m = ['TTT', 'TTH', 'THT', 'THH', 'HTT', 'HTH', 'HHT', 'HHH']

import collections

T, *S = map(lambda x:x.rstrip(), sys.stdin)
for i in S:
    z = collections.Counter(zip(i, i[1:], i[2:]))
    z = map(lambda x:(''.join(x[0]), x[1]), z.items())
    z = collections.defaultdict(int, z)
    print(*map(lambda x: z[x], m))