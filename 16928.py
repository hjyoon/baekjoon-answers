import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
m = [0]*101
r = [999999]*101
for i in range(N+M):
    x, y = map(int, input().rstrip().split())
    m[x] = y

def go(now, step):
    #print(now, step)
    if now > 100:
        return
    if step >= r[now]:
        return
    r[now] = step
    if m[now] != 0:
        go(m[now], step)
        return
    if now == 100:
        return
    for i in range(1, 7):
        go(now+i, step+1)

go(1, 0)
#print(*r)
print(r[100])