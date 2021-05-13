import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, _ = map(int, input().rstrip().split())
S = set(map(int, input().rstrip().split()))

ans = float('inf')

for x in range(1, 1002):
    if x in S:
        continue
    for y in range(x, 1002):
        if y in S:
            continue
        for z in range(y, 1002):
            if z in S:
                continue
            q = x*y*z
            t = abs(N - q)
            if ans > abs(N - q):
                ans = abs(N - q)
                print(x, y, z, t)
            if N+1 < q:
                break

print(ans)