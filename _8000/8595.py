import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import re

N = map(int, input().rstrip().split())
S = input().rstrip()
S = re.sub('[a-zA-Z]', ' ', S)

print(sum(map(int, S.split())))