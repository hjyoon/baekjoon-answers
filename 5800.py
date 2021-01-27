import sys
sys.stdin = open("input.txt", 'r')

K = int(input())
for i in range(1, K+1):
    N, *l = map(int, input().split())
    l.sort(reverse=True)
    print(f'Class {i}')
    mx = max(l)
    mn = min(l)
    gap = max(zip(l,l[1:]), key=lambda x: abs(x[0]-x[1]))
    print(f'Max {mx}, Min {mn}, Largest gap {abs(gap[0]-gap[1])}')