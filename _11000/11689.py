import sys
sys.stdin = open("input.txt", 'r')
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

def euler_phi(n):
    phi = int(n > 0 and n)
    for p in range(2, int(n ** .5) + 1):
        if not n % p:
            phi -= phi // p
            while not n % p:
                n //= p
    if n > 1: phi -= phi // n
    return phi

N = int(input().rstrip())
print(euler_phi(N))