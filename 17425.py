import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input())
for _ in range(N):
    n = int(input())
    #Sum_{k=1..n} k*floor(n/k)
    ans = 0
    for k in range(1, n+1):
        ans += k*(n//k)
    print(ans)