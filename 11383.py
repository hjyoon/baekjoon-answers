import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

N, M = map(int, input().split())
A = [input().rstrip() for _ in range(N)]
B = [input().rstrip() for _ in range(N)]

import functools

# r = True
# for i, v in enumerate(A):
#     if B[i] != functools.reduce(lambda x,y:x+y*2, v, ''):
#         r = False
# print('Eyfa' if r else 'Not Eyfa')

def f(x):
    return functools.reduce(lambda a,b:a+b*2, x, '')

C = list(map(f, A))
print('Eyfa' if B == C else 'Not Eyfa')