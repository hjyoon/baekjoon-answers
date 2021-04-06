import sys
sys.stdin = open("input.txt", 'r')
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

def get_divisor(n):
    n = int(n)
    divisors = []
    divisors_back = [] 

    for i in range(1, int(n**(1/2)) + 1): 
        if (n % i == 0):            
            divisors.append(i)
            if (i != (n // i)): 
                divisors_back.append(n//i)

    return divisors + divisors_back[::-1]

N = int(input().rstrip())
l = get_divisor(N)

for v in l:
    if euler_phi(v) == N//v:
        print(v)
        exit()
print(-1)