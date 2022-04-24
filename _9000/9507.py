import sys
sys.stdin = open("input.txt", 'r')
T, *S = map(int, sys.stdin)
res = [1, 1, 2, 4] + [0] * 64
for i in range(4, 68):
    res[i] = sum(res[i-4:i])
for i in S:
    print(res[i])