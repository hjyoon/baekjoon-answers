import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())

a = [0]*N

def chk(n):
    l = 1
    while True:
        if l*2 > n+1:
            break
        t = None
        if n+1 == l*2:
            t = a[n::-1]
        else:
            t = a[n:n-l*2:-1]
        b = t[:len(t)//2]
        c = t[len(t)//2:]
        if b == c:
            return True
        l += 1
    return False

def dfs(n):
    if n == N:
        return True
    for i in range(1, 4):
        a[n] = i
        if chk(n):
            continue
        if dfs(n+1):
            return True
    return False
dfs(0)
print(*a, sep='')