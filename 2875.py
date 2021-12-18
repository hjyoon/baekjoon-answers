import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, M, K = map(int, input().split())
cnt_team = min(N//2, M)
rest = N+M-(cnt_team*3)
rest -= K
rest //= 3
if rest < 0:
    cnt_team += rest
print(cnt_team)
