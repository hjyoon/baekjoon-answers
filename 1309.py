import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())
t = [1,1,1]
for i in range(N-1):
    a, b, c = t
    t = [(a+c)%9901, (b+c)%9901, (a+b+c)%9901]
print(sum(t)%9901)