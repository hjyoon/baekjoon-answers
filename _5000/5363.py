import sys
sys.stdin = open("input.txt", 'r')

N, *S = map(lambda x:x.rstrip(), sys.stdin)

for i in S:
    i = i.split()
    print(*i[2:], *i[:2])