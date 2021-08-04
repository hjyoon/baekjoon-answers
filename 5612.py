import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input())
M = int(input())
S = []

res = M
for _ in range(N):
    _in, _out = map(int, input().split())
    M += _in
    M -= _out
    res = max(res, M)
    if M < 0:
        res = 0
        break
print(res)