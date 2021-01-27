import sys
sys.stdin = open("input.txt", 'r')

T = int(input())
for _ in range(T):
    P, M = map(int, input().split())
    s = set()
    for _ in range(P):
        s.add(int(input()))
    print(P-len(s))