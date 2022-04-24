import sys
sys.stdin = open("input.txt", 'r')

N, *S, K = map(lambda x: x.rstrip(), sys.stdin)
N = int(N)
K = int(K)
if K == 1:
    for i in S:
        print(i)
elif K == 2:
    for i in S:
        print(i[::-1])
else:
    for i in S[::-1]:
        print(i)