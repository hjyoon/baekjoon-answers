import sys
sys.stdin = open("input.txt", 'r')

A, B = map(lambda x: x.rstrip(), sys.stdin)
print('go' if A <= B else 'no')