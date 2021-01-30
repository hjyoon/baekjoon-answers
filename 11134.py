import sys
sys.stdin = open("input.txt", 'r')

_, *S = map(lambda x: x.rstrip(), sys.stdin)

for i in S:
    N, C = map(int, i.split())
    print(N//C if N%C == 0 else N//C+1)