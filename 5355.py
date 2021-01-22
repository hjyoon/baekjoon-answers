import sys
sys.stdin = open("input.txt", 'r')

T = int(input())
for i in range(T):
    l = tuple(input().split())
    v = float(l[0])
    for j in range(1, len(l)):
        if l[j] == '@':
            v *= 3
        elif l[j] == '%':
            v += 5
        elif l[j] == '#':
            v -= 7

    print(f'{v:.2f}')