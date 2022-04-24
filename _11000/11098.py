import sys
sys.stdin = open("input.txt", 'r')

T = int(input())

for _ in range(T):
    P = int(input())
    tmp = []
    for _ in range(P):
        C, NAME = input().split(); C = int(C)
        tmp.append((C, NAME))
    tmp.sort(reverse=True)
    print(tmp[0][1])