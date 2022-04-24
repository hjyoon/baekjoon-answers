import math
import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

M = int(input())
N = int(input())


def chk(n):
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True


l = []
for n in range(M, N+1):
    if n == 1:
        continue
    if chk(n):
        l.append(n)
if len(l):
    print(sum(l), l[0], sep='\n')
else:
    print(-1)
