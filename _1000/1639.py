import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = input().rstrip()

ans = 0
for l in range(2, len(S)+1, 2):
    for i in range(0, len(S)-(l-1)):
        t = S[i:i+l]
        a = map(int, t[:len(t)//2])
        b = map(int, t[len(t)//2:])
        if sum(a) == sum(b):
            ans = l
print(ans)