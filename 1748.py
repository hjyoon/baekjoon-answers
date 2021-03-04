import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

t = map(lambda x:(10**x, x*9*10**(x-1)), range(1, 10))

n = int(input())
res = 0
for i in t:
    if n >= i[0]:
        res += i[1]
    else:
        res += (n - i[0]//10 + 1) * len(str(n))
        break

print(res)