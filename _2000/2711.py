import sys
sys.stdin = open("input.txt", 'r')

l = []
for i in range(1, 46):
    l += [i]*i

a, b = map(int, input().split())
print(sum(l[a-1:b]))