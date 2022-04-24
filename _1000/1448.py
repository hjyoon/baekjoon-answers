import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())
S = []
for _ in range(N):
    S.append(int(input().rstrip()))
S.sort(reverse=True)

ans = -1
for v in zip(S, S[1:], S[2:]):
    if v[0] < v[1] + v[2]:
        ans = sum(v)
        break
print(ans)