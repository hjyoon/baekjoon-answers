import sys
sys.stdin = open("input.txt", 'r')

n = int(input())

i = 2
while i**2<=n:
    if n%i==0:
        n //= i
        print(i)
    else:
        i += 1

if n>1:
    print(n)