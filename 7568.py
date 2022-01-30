import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input())
S = [list(map(int, input().split())) for _ in range(N)]

rank = [1] * N

for i in range(N):
    for j in range(N):
        if i != j:
            if S[i][0] < S[j][0] and S[i][1] < S[j][1]:
                rank[i] += 1
print(*rank)
