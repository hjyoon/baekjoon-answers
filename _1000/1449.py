import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, L = map(int, input().rstrip().split())
S = map(int, input().rstrip().split())

a = [0] * 1001
ans = 0

for v in S:
    a[v] = 1

i = 1
while True:
    if i > 1000:
        break
    if a[i] == 1:
        ans += 1
        for _ in range(L):
            if i > 1000:
                break
            a[i] = 0
            i += 1
    else:
        i += 1

print(ans)