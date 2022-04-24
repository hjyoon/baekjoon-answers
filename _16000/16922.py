import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools

N = int(input().rstrip())

s = set()
for v in itertools.combinations_with_replacement([1,5,10,50], N):
    s.add(sum(v))
print(len(s))