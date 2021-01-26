import sys
sys.stdin = open("input.txt", 'r')

T = int(input())
for _ in range(T):
    n = int(input())
    l = list(map(int, input().split()))
    l.sort()
    print((l[-1]-l[0])*2)