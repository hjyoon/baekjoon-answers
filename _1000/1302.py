import sys
from collections import defaultdict
input = sys.stdin.readline

d = defaultdict(int)

N = int(input())

for i in range(N):
    s = input().rstrip()
    d[s] += 1

print(sorted(d.items(), key=lambda x:(-x[1], x[0]))[0][0])