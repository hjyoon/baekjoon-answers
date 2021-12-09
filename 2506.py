import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input())
S = map(int, input().split())

res = 0
import itertools
for v, grouper in itertools.groupby(S):
    if v == 1:
        res += sum(range(1, len(list(grouper))+1))