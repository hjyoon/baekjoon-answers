import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A = sorted(input().rstrip())
B = sorted(input().rstrip())

import collections
a = collections.Counter(A)
b = collections.Counter(B)
c = a&b
print(sum((a-c).values()) + sum((b-c).values()))