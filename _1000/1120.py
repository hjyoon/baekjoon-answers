import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

def chk(A, B, size):
    c = 0
    for i in range(size):
        if A[i] != B[i]:
            c += 1
    return c

A, B = input().rstrip().split()

r = 50
for i in range(len(B)-len(A)+1):
    r = min(r, chk(A, B[i:i+len(A)], len(A)))
print(r)