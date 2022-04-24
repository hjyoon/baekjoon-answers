import sys
sys.stdin = open("input.txt", 'r')

T = int(input())
for _ in range(T):
    l = list(map(int, input().split()))
    l = sorted(l)[1:4]
    if l[-1] - l[0] >= 4:
        print('KIN')
    else:
        print(sum(l))