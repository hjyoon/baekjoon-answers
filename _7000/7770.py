import sys
sys.setrecursionlimit(1000000)
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

def upper_bound(s, e, d, l):
    while(e - s > 0):
        m = (s+e)//2
        if(l[m] <= d):
            s = m+1
        else:
            e = m
    return e+1

N = int(input().rstrip())

t = []
for i in range(1, 1145):
    a = i*(2*i**2 + 1)//3
    t.append(a)

print(upper_bound(0, len(t), N, t)-1)