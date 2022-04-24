import sys
sys.stdin = open("input.txt", 'r')

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    p = [0] * N
    for i in range(N):
        p[i] = int(input())
    t = sum(p)
    p = sorted(enumerate(p), key=lambda x:x[1], reverse=True)
    #print(p)
    if p[0][1] == p[1][1]:
        print('no winner')
        continue
    if p[0][1] > t//2:
        print(f'majority winner {p[0][0]+1}')
    else:
        print(f'minority winner {p[0][0]+1}')