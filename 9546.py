import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

T, *K = map(lambda x:x.rstrip(), sys.stdin)
K = map(int, K)
for v in K:
    res = 0
    for c in range(v):
        res = (res + 0.5)*2
    print(int(res))