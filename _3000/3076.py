import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

R, C = map(int, input().rstrip().split())
A, B = map(int, input().rstrip().split())

sw = 0

for i in range(R):
    for k in range(A):
        for j in range(C):
            if j%2 == sw:
                print('X'*B, end='')
            else:
                print('.'*B, end='')
        print()
    sw = 1 - sw