import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import functools

N = input().rstrip()
for i in range(1, len(N)):
    a = functools.reduce(lambda x,y:int(x)*int(y),N[:i],1)
    b = functools.reduce(lambda x,y:int(x)*int(y),N[i:],1)
    print(a, b)
    if a == b:
        print('YES')
        exit()
print('NO')