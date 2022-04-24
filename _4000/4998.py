import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = map(lambda x:x.rstrip(), sys.stdin)
for v in S:
    N, B, M = map(float, v.rstrip().split())
    r = N
    c = 0
    while True:
        if r > M:
            break
        r *= 1+(B/100)
        c += 1
    print(c)