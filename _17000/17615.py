import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline


N = int(input())
S = input().rstrip()
ans = 0

if S[:N].count('B') >= S[N:].count('B'):
    left_side = 'B'
    right_side = 'R'
else:
    left_side = 'R'
    right_side = 'B'

print(left_side, right_side)

for i in range(0, N//2):
    if S[i] != left_side:
        print(S[i], left_side)
        ans += 1

for i in range(N//2, N):
    if S[i] != right_side:
        print(S[i], right_side)
        ans += 1

print(ans)
