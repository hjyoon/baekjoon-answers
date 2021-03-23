import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, P = map(int, input().rstrip().split())

d = {}
a = N
c = 0
while True:
    a = a*N%P
    c += 1
    if a in d:
        print(c - d[a])
        break
    else:
        d[a] = c