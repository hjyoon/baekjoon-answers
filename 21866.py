import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

chk = [100, 100, 200, 200, 300, 300, 400, 400, 500]
S = list(map(int, input().split()))

for i in range(len(chk)):
    if S[i] > chk[i]:
        print('hacker')
        exit()

if sum(S) >= 100:
    print('draw')
else:
    print('none')
