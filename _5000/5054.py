import sys
sys.stdin = open("input.txt", 'r')

T = int(input())
for _ in range(T):
    n = int(input())
    l = list(map(int, input().split()))
    print((max(l)-min(l))*2)