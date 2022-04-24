import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools

N = int(input().rstrip())
E = map(int, input().rstrip().split())
V = list(map(int, input().rstrip().split()))

a = list(itertools.accumulate(E, lambda x,y:x+y))

s = [0]
st = V[0]
for i, v in enumerate(V[1:-1], 1):
    if st > v:
        st = v
        s.append(i)
s.append(len(V)-1)

s = zip(s, s[1:])
r = 0
for x, y in s:
    if x-1 < 0:
        r += V[x] * a[y-1]
    else:
        r += V[x] * (a[y-1] - a[x-1])

print(r)