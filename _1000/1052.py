import sys
input = sys.stdin.readline

N, K = map(int, input().split())

b_str = bin(N)[2:]

if b_str.count('1') <= K:
    print(0)
    exit(0)

pos = 0
cnt = 0
for i in range(len(b_str)):
    if b_str[i] == '1':
        cnt += 1
    if cnt == K:
        pos = i
        break

ans = 2 ** len(b_str[pos:]) - int(b_str[pos:], 2)
print(ans)
