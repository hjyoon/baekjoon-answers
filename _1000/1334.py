import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = input().rstrip()

if N == '9':
    print(11)
    exit(0)

c1 = None
c2 = None

if len(N) % 2 == 0:
    left = N[:len(N)//2]
    right = N[len(N)//2:]
    c1 = int(left + left[::-1])
    t = str(int(left)+1)
    if len(t) == len(left):
        c2 = int(t + t[::-1])
    else:
        c2 = int(t + t[::-1][1:])
else:
    left = N[:len(N)//2+1]
    right = N[len(N)//2+1:]
    c1 = int(left + left[::-1][1:])
    t = str(int(left)+1)
    if len(t) == len(left):
        c2 = int(t + t[::-1][1:])
    else:
        c2 = int(t + t[::-1][2:])

if int(N) < c1:
    print(c1)
else:
    print(c2)