import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

l = None

def dc(s, e):
    if s == e:
        return
    gap = (e - s + 1) // 3
    sec = [(s, s+gap-1), (s+gap, s+gap*2-1), (s+gap*2, s+gap*3-1)]
    dc(sec[0][0], sec[0][1])
    l[sec[1][0]:sec[1][1]+1] = [' '] * gap
    dc(sec[2][0], sec[2][1])

N = map(int, sys.stdin)
for v in N:
    v = 3**v
    l = ['-'] * v
    dc(0, v-1)
    print(*l, sep='')