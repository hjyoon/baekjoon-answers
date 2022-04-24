import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

N, M = map(int, input().split())
S = list(map(int, input().split()))

ans = 0

for i in range(N):
    for j in range(i+1, N):
        for k in range(j+1, N):
            tmp = S[i] + S[j] + S[k]
            if tmp <= M:
                ans = max(ans, tmp)

print(ans)
