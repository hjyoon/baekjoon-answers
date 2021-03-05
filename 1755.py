import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

t = {'0':'zero','1':'one','2':'two','3':'three','4':'four','5':'five','6':'six','7':'seven','8':'eight','9':'nine'}

M, N = map(int, input().split())

def mapping(v):
    return (' '.join(map(lambda x:t[x], v)), v)

l = map(str, range(M, N+1))
l = sorted(map(mapping, l))
l = tuple(map(lambda x:x[1], l))

for i in range(0, len(l), 10):
    print(*l[i:i+10])