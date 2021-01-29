import sys
sys.stdin = open("input.txt", 'r')

S = filter(lambda x: x not in 'CAMBRIDGE', input())
print(''.join(S))