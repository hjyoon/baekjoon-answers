import sys
sys.stdin = open("input.txt", 'r')

a = [0] * 1000001
for i in range(1000001):
    a[i] = str(i).count('0')

_, *S = map(lambda x: x.rstrip(), sys.stdin)
for i in S:
    N, M = map(int, i.split())
    # res = "".join(map(str, range(N, M+1)))
    cnt = sum(a[N:M+1])
    print(cnt)