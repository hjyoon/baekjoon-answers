import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = input().rstrip()

i = 0
ans = 0
for v in S:
    if str.isupper(v):
        if i % 4 != 0:
            ans += 4 - (i % 4)
            i = (i // 4 + 1) * 4
        #print(v, i, ans)
    i += 1
print(ans)