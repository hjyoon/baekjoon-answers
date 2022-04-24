import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

t = ((0,1,2),(3,4,5),(6,7,8),(0,3,6),(1,4,7),(2,5,8),(0,4,8),(2,4,6))

def chk(l):
    for v in t:
        tmp = set(map(lambda x:l[x], v))
        if len(tmp) == 1:
            return tmp.pop()
    return 0

P, *S = map(lambda x:x.rstrip(), sys.stdin)
P = int(P)
l = [0]*9
res = 0
for v in S:
    y, x = map(int, v.split())
    l[3*(y-1)+x-1] = P
    res = chk(l)
    if res != 0:
        break
    P = 3-P
print(res)