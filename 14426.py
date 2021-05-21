import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
S = [input().rstrip() for _ in range(N)]
T = [input().rstrip() for _ in range(M)]

ans = 0

for v in T:
    for w in S:
        if v == w[:len(v)]:
            ans += 1
            break

print(ans)