import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

T = input().rstrip().replace('*', '.')
_, *S = map(lambda x:x.rstrip(), sys.stdin)

import re
p = re.compile(T)

res = []

for v in S:
    if p.match(v) != None:
        res.append(v)

print(len(res), *res, sep='\n')