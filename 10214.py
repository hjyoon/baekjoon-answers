import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    Y, K = 0, 0
    for _ in range(9):
        y, k = map(int, input().split())
        Y += y
        K += k
    if Y > K:
        print('Yonsei')
    elif Y < K:
        print('Korea')
    else:
        print('Draw')