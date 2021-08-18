import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    H, W, N = map(int, input().split())
    print(f'{(N-1)%H+1}{(N-1)//H+1:02d}')
