import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

def cal(l):
    m = 0
    c = 0
    for v in l:
        if v == 1:
            m += c
        else:
            c += 1
    return m

T = int(input())
for i in range(T):
   M, N = map(int, input().split())
   t = [list(map(int, input().split())) for _ in range(M)]
   t = list(zip(*t[::-1]))
   res = 0
   for v in t:
       res += cal(v)

   print(res)