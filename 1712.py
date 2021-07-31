import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A, B, C = map(int, input().split())

if B >= C:
    print(-1)
    exit(0)

print(A//(C-B)+1)