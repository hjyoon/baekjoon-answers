import sys
sys.stdin = open("input.txt", 'r')

def gcd(x, y):
    while True:
        x, y = y, x%y
        if y == 0:
            return x

def lcm(x, y):
    return (x*y)//gcd(x, y)

T, *N = map(lambda x: x.rstrip(), sys.stdin)
for i in N:
    a, b = map(int, i.split())
    print(lcm(a, b), gcd(a, b))