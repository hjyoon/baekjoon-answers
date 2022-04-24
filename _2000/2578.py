import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = 5
b = [0]*(N*N)

S = map(lambda x:x.rstrip(), sys.stdin)

m = list()
for i in range(N):
    m.extend(map(int, input().split()))

l = list()
for _ in range(N):
    l.extend(map(int, input().split()))

# make patterns list
p = list()
for i in range(N):
    p.append([i*N+j for j in range(N)])
    p.append([j*N+i for j in range(N)])
p.append([(N+1)*i for i in range(N)])
p.append([(N-1)*(i+1) for i in range(N)])

def check():
    cnt = 0
    for v in p:
        tmp = map(lambda x:b[x], v)
        if sum(tmp) == N:
            cnt += 1
    
    if cnt > 2:
        return True
    else:
        return False

for i, v in enumerate(l, 1):
    j = m.index(v)
    b[j] = 1
    if check() == True:
        print(i)
        break