import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, A, B = map(int, input().rstrip().split())

if A > B:
    A, B = B, A

ans = 1
while True:
    if A%2 == 1 and A+1 == B:
        break
    A = (A+1)//2
    B = (B+1)//2
    ans += 1

print(ans)