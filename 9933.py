import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools

N = int(input().rstrip())
S = []
for i in range(N):
    S.append(input().rstrip())

for a, b in itertools.combinations_with_replacement(S, 2):
    if a == b[::-1]:
        print(len(a), a[len(a)//2])