import sys
sys.stdin = open("input.txt", 'r')

T = int(input())
for _ in range(T):
    l = list(map(int, input().split()))
    l = sorted(l)
    print(l[-3])