import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

S = list(map(int, input().split()))

if S == list(range(1, 9, 1)):
    print('ascending')
elif S == list(range(8, 0, -1)):
    print('descending')
else:
    print('mixed')
