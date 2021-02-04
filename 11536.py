import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

T, *S = map(lambda x:x.rstrip(), sys.stdin)
if S == sorted(S):
    print('INCREASING')
elif S == sorted(S, reverse=True):
    print('DECREASING')
else:
    print('NEITHER')