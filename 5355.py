import sys
sys.stdin = open("input.txt", 'r')

T = int(input())
for i in range(T):
    v, *l = tuple(input().split())
    v = float(v)
    for j in l:
        if j == '@':
            v *= 3
        elif j == '%':
            v += 5
        elif j == '#':
            v -= 7

    print(f'{v:.2f}')