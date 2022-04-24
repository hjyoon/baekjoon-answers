import sys
sys.stdin = open("input.txt", 'r')

A, B = map(lambda x: x[::-1], input().split())

import itertools

C = itertools.zip_longest(A, B, fillvalue='0')
C = map(lambda x: str(int(x[0]) + int(x[1])), C)
print(''.join(list(C)[::-1]))