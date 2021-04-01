import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import math

_, *S = map(lambda x:int(x.rstrip()), sys.stdin)
S = sorted(S[:_])
t = []
a = S[0]
for i in range(1, len(S)):
    b = S[i]
    t.append(b-a)
    a = b

r = math.gcd(*t)
print(sum(t)//r-len(t))
#print(sum(i//r-1 for i in t))