import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

T = int(input())

for i in range(T):
    N, D = map(int, input().split())
    cnt = 0
    for j in range(N):
        V, F, C = map(int, input().split())
        if V/C*F >= D:
            cnt += 1
    print(cnt)