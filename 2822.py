import sys
sys.stdin = open("input.txt", 'r')

for _ in range(8):
    n = int(input())
    l = list(map(int, input().split()))
    print((max(l)-min(l))*2)