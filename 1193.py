import bisect
import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

N = int(input())

l = [1]
i = 1
while l[-1] < 10000000:
    l.append(l[-1]+i)
    i += 1

cnt_limit = bisect.bisect(l, N) - 1

a = N - l[cnt_limit] + 1
b = l[cnt_limit+1] - N

if cnt_limit % 2 == 1:
    print(f'{a}/{b}')
else:
    print(f'{b}/{a}')
