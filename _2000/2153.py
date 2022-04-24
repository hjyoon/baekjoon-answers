import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

def isPrime(n):
    if n == 1:
        return True
    for i in range(2, int(n**0.5)+1):
        if n % i == 0:
            return False
    return True

t = dict(zip(map(chr, range(65, 91)), map(int, range(27, 53))))
t.update(dict(zip(map(chr, range(97, 123)), map(int, range(1, 27)))))
S = input().rstrip()

import functools
res = functools.reduce(lambda a,b:a+t[b], S, 0)

print(f"It is {'' if isPrime(res) == True else 'not '}a prime word.")