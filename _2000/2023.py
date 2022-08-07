def isPrime(n):
    if n < 2:
        return False
    if n in (2, 3):
        return True
    if n % 2 == 0 or n % 3 == 0:
        return False
    if n < 9:
        return True
    k, l = 5, n**0.5
    while k <= l:
        if n % k == 0 or n % (k+2) == 0:
            return False
        k += 6
    return True

N = int(input())

def dfs(s):
    n = int(s)
    if isPrime(n):
        if len(s) == N:
            print(n)
            return
        for i in [1, 3, 7, 9]:
            dfs(f'{n}{i}')

for i in [2, 3, 5, 7]:
    dfs(f'{i}')