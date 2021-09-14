from pprint import pprint
import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline


L = int(input())
S = tuple(map(int, input().split()))

can_connect = {
    1: {2, 4, 5, 6, 8},
    2: {1, 3, 4, 5, 6, 7, 9},
    3: {2, 4, 5, 6, 8},
    4: {1, 2, 3, 5, 7, 8, 9},
    5: {1, 2, 3, 4, 6, 7, 8, 9},
    6: {1, 2, 3, 5, 7, 8, 9},
    7: {2, 4, 5, 6, 8},
    8: {1, 3, 4, 5, 6, 7, 9},
    9: {2, 4, 5, 6, 8},
}


def extra(d, n):
    if n == 5:
        d[1].add(9)
        d[2].add(8)
        d[3].add(7)
        d[4].add(6)
        d[6].add(4)
        d[7].add(3)
        d[8].add(2)
        d[9].add(1)
    elif n == 2:
        d[1].add(3)
        d[3].add(1)
    elif n == 4:
        d[1].add(7)
        d[7].add(1)
    elif n == 6:
        d[3].add(9)
        d[9].add(3)
    elif n == 8:
        d[7].add(9)
        d[9].add(7)
    else:
        pass


visit = [0]*10
visit[S[0]] = 1
extra(can_connect, S[0])
OK = False

for i in range(1, L):
    if S[i] in can_connect[S[i-1]] and visit[S[i]] == 0:
        visit[S[i]] = 1
        extra(can_connect, S[i])
    else:
        break
else:
    OK = True

if OK:
    print("YES")
else:
    print("NO")
