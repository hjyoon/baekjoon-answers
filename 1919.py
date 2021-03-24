import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A = sorted(list(input().rstrip()))
B = sorted(list(input().rstrip()))

import collections

a = collections.Counter(A)
b = collections.Counter(B)

print(sum((a-b).values()) + sum((b-a).values()))