import sys
sys.stdin = open("input.txt", 'r')

X = map(lambda x: x.rstrip(), sys.stdin)

import itertools

for i in X:
    tmp = map(lambda x:len(list(x[1])), itertools.groupby(i))
    print(max(tmp))