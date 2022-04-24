import sys
import random
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

def miller_rabin(n, k):
    # Implementation uses the Miller-Rabin Primality Test
    # The optimal number of rounds for this test is 40
    # See http://stackoverflow.com/questions/6325576/how-many-iterations-of-rabin-miller-should-i-use-for-cryptographic-safe-primes
    # for justification

    # If number is even, it's a composite number
    if n == 2 or n == 3:
        return True

    if n % 2 == 0:
        return False

    r, s = 0, n - 1
    while s % 2 == 0:
        r += 1
        s //= 2
    for _ in range(k):
        a = random.randrange(2, n - 1)
        x = pow(a, s, n)
        if x == 1 or x == n - 1:
            continue
        for _ in range(r - 1):
            x = pow(x, 2, n)
            if x == n - 1:
                break
        else:
            return False
    return True

T, *S = map(lambda x:x.rstrip(), sys.stdin)
T = int(T)
for v in S[:T]:
    a, b = map(int, v.split())
    c = a+b
    if c in [1,2,3]:
        print('NO')
    elif c%2 == 0:
        print('YES')
    elif miller_rabin(c-2, 20):
        print('YES')
    else:
        print('NO')