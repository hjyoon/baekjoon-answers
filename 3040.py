import sys
sys.stdin = open("input.txt", 'r')

from itertools import combinations

l = list(map(int, sys.stdin))
for i in list(combinations(l, 7)):
    if sum(i) == 100:
        print('\n'.join(map(str, i)))