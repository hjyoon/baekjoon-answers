import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

N = int(input())

res = 0
cnt = 0
d = {N: 0}
while True:
    if N < 10:
        N = 10*N+N
    else:
        N = str(N)
        tmp = int(N[1])
        N = int(N[0]) + tmp
        N = str(N)
        N = int(str(tmp) + N[-1])
    cnt += 1
    if N in d:
        res = cnt - d[N]
        break
    else:
        d[N] = cnt

print(res)
