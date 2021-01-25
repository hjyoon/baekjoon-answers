import sys
sys.stdin = open("input.txt", 'r')

T = int(input())
for _ in range(T):
    pos, s = input().split(); pos = int(pos)
    print(s[:pos-1] + s[pos:])