import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

for line in sys.stdin:
    n, k = map(int, line.split())
    res = 0
    stamp = 0
    while n != 0:
        res += n
        stamp += n
        n = stamp//k
        stamp %= k
    print(res)
