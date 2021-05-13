import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = input().rstrip()

if N == '9':
    print(11)
else:
    if len(N) % 2 == 0:
        left = N[:len(N)//2]
        right = N[len(N)//2:]
        c1 = int(left + left[::-1])
        c2 = None
        t = str(int(left)+1)
        if len(t) == len(left):
            c2 = int(t + t[::-1])
        else:
            c2 = int(t + t[::-1][1:])
        if int(N) < c1:
            print(c1)
        else:
            print(c2)
    else:
        left = N[:len(N)//2+1]
        right = N[len(N)//2+1:]
        c1 = int(left + left[::-1][1:])
        c2 = None
        t = str(int(left)+1)
        if len(t) == len(left):
            c2 = int(t + t[::-1][1:])
        else:
            c2 = int(t + t[::-1][2:])
        if int(N) < c1:
            print(c1)
        else:
            print(c2)