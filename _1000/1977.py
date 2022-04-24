import sys
sys.stdin = open("input.txt", 'r')

N = int(input())
M = int(input())

a = list(filter(lambda x: (x**0.5).is_integer(), range(N, M+1)))

if not a:
    print(-1)
else:
    print(sum(a))
    print(a[0])