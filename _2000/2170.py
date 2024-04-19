import sys
input = sys.stdin.readline

N = int(input())  # 1 ≤ N ≤ 1,000,000
S = sorted([tuple(map(int, input().split()))
           for _ in range(N)], key=lambda x: x[0])

last_r = S[0][1]
ans = abs(S[0][1] - S[0][0])

for i in range(1, N):
    l, r = S[i]
    if r <= last_r:
        continue
    elif l <= last_r:
        ans += abs(r-last_r)
    else:
        ans += abs(r-l)
    last_r = r

print(ans)
