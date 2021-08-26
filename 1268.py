import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

N = int(input())
S = [[int(n) for n in input().split()] for i in range(1, N+1)]

d = {i: set() for i in range(1, N+1)}


S = zip(*S)

for students in S:
    for axis in range(N):
        tmp = students[axis]
        for i in range(N):
            if students[i] == tmp:
                d[axis+1].add(i+1)

res = 0
res_size = 0
for i in range(N, 0, -1):
    if len(d[i]) >= res_size:
        res_size = len(d[i])
        res = i
print(res)
print(d)
