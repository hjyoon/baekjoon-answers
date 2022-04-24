import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

def T(n):
    return (n**2+n)//2

d = [0]*301

_, *S = map(lambda x:x.rstrip(), sys.stdin)

for v in S:
    v = int(v)
    if d[v] != 0:
        print(d[v])
        continue
    sum = 0
    for i in range(1, v+1):
        sum += i*T(i+1)
    d[v] = sum
    print(d[v])