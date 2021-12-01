import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

res = 0
cur = 0
for _ in range(4):
    _out, _in = map(int, input().split())
    cur -= _out
    cur += _in
    res = max(res, cur)
print(res)
