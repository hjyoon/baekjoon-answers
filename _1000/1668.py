import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input())
S = [int(input()) for _ in range(N)]

ans = 0
last = 0
for i in range(N):
    if last < S[i]:
        last = S[i]
        ans += 1
    
print(ans)

ans = 0
last = 0
for i in range(N-1, -1, -1):
    if last < S[i]:
        last = S[i]
        ans += 1

print(ans)