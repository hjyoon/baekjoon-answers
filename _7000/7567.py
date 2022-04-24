import sys
sys.stdin = open("input.txt", 'r')

s = input()

res = 10
for i, v in enumerate(s):
    if i == 0: continue
    if s[i-1] == s[i]:
        res += 5
    else:
        res += 10

print(res)