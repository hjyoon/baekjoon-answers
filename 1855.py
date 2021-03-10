import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

K, S = map(lambda x:x.rstrip(), sys.stdin)
K = int(K)
C = len(S)//K
res = list()
for i in range(C):
    if i%2==0:
        res.append(S[i*K:(i+1)*K])
    else:
        res.append(S[(i+1)*K-1:i*K-1:-1])

res2 = map(lambda x:''.join(x), zip(*res))
print(''.join(res2))