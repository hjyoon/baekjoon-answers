import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A, B = map(int, input().split())
C, D = map(int, input().split())
l = [[A, B], [C, D]]
res = None
res_max = 0
for i in range(4):
    if res_max < l[0][0]/l[1][0] + l[0][1]/l[1][1]:
        res_max = l[0][0]/l[1][0] + l[0][1]/l[1][1]
        res = i
    l = zip(*l)
    l = list(map(lambda x: x[::-1], l))
print(res)
