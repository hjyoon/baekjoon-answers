import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(lambda x:x.rstrip(), sys.stdin)
N, M = map(int, _.split())

t = [[0]*100 for i in range(100)]

for v in S:
    x1, y1, x2, y2 = map(int, v.split())
    for i in range(y1-1, y2):
        for j in range(x1-1, x2):
            t[i][j] += 1
res = 0
for i in range(100):
    for j in range(100):
        if t[i][j] > M:
            res += 1
            
print(res)