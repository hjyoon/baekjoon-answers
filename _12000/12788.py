import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())
M, K = map(int, input().rstrip().split())
A = sorted(map(int, input().rstrip().split()), reverse=True)

limit = M*K
res = 0
cnt = 0
for v in A:
    if res >= limit:
        break
    else:
        res += v
        cnt += 1
if res >= limit:
    print(cnt)
else:
    print('STRESS')