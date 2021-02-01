import sys
sys.stdin = open("input.txt", 'r')

A, _, *S = map(lambda x:x.rstrip(), sys.stdin)

S = list(map(lambda x:x*2, S))
n = 0
for i in S:
    if A in i:
        n += 1
print(n)