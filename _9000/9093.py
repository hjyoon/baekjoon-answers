import sys
sys.stdin = open("input.txt", 'r')

T, *S = map(lambda x: x.rstrip(), sys.stdin)

for i in S:
    i = map(lambda x: x[::-1], i.split())
    print(' '.join(i))