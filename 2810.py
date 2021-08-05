import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

N = int(input())
S = input().rstrip()
res = S.count('S') + S.count('LL') + 1
print(min(res, N))