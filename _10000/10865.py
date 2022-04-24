import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
S = map(lambda x:x.rstrip(), sys.stdin)

t = [0]*N
for v in S:
    a, b = map(int, v.split())
    t[a-1] += 1
    t[b-1] += 1
print(*t, sep='\n')