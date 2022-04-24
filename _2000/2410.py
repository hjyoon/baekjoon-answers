import sys
sys.setrecursionlimit(100000000)
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

N = int(input())

def a(n):
    return bin(n).count('1')

def dp(n):
    #print(f'dp({n})')
    if n == 0:
        return 1
    return a(n) * dp(n-a(n))

for i in range(1, 1000):
    print(f'dp({i})={dp(i+1)}')

print(dp(N+1)%1000000000)

dict().setdefault