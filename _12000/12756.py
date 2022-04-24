import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A, B = map(lambda x:x.rstrip(), sys.stdin)
A1, H1 = map(int, A.split())
A2, H2 = map(int, B.split())
while True:
    H1 -= A2
    H2 -= A1
    if H1 <= 0 or H2 <= 0:
        break
if H1 <= 0 and H2 > 0:
    print('PLAYER B')
elif H2 <= 0 and H1 > 0:
    print('PLAYER A')
else:
    print('DRAW')