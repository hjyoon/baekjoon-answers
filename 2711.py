import sys
sys.stdin = open("input.txt", 'r')

l = []
def list_init():
    cnt = 0
    while True:
        for i in range(1, 46):
            for _ in range(i):
                cnt+=1
                l.append(i)
                if cnt == 1000:
                    return
list_init()
a, b = map(int, input().split())
print(sum(l[a-1:b]))