import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, C = map(int, input().rstrip().split())

ans = (N-1) * -C

for i in range(N):
    mm, ss = map(int, input().rstrip().split(':'))
    ans += mm*60 + ss

print(f'{ans//3600:02d}:{ans%3600//60:02d}:{ans%3600%60:02d}')