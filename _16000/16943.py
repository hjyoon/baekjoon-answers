import sys
import itertools
input = sys.stdin.readline

A, B = input().rstrip().split()
INT_B = int(B)

visit = [0] * len(A)
C = []
ans = -1

def bt(pos):
    global ans
    if pos >= len(A):
        tmp = int(''.join(C))
        if C[0] != '0' and tmp < INT_B:
            ans = max(ans, tmp)
        return
    for i in range(len(A)):
        if visit[i] == 1:
            continue

        visit[i] = 1
        C.append(A[i])

        bt(pos+1)

        visit[i] = 0
        C.pop()

bt(0)

print(ans)
