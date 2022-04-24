from pprint import pprint
import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

S = list(map(int, input().split()))

tmp = min(S)
res = tmp
for i in range(3):
    S[i] -= tmp
    res += S[i]//3
    S[i] %= 3

if sum(S) > 2:
    res += 2
elif sum(S) != 0:
    res += 1

print(res)
