import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

def T(n):
    return (n**2+n)//2

_, *S = map(lambda x:x.rstrip(), sys.stdin)

for v in S:
    sum = 0
    for i in range(1, int(v)+1):
        sum += i*T(i+1)
    print(sum)