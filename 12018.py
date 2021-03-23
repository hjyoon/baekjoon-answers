import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())

a = []

for i in range(N):
    P, L = map(int, input().rstrip().split())
    S = sorted(map(int, input().rstrip().split()))
    if P < L:
        a.append(1)
    else:
        a.append(S[P-L])
a.sort()

c = 0
for v in a:
    M -= v
    if M < 0:
        break
    c += 1
print(c)