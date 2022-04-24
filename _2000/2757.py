import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = map(lambda x:x.rstrip(), sys.stdin)

t = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
#t = [chr(i) for i in range(ord('A'), ord('Z')+1)]

import re

for v in S:
    a, b = map(int, re.findall('[A-Z]([0-9]+)', v))
    if a == 0 and b == 0:
        break
    ans = []
    while True:
        if b == 0:
            break
        b -= 1
        ans.append(t[b%26])
        b //= 26
    print(f"{''.join(ans[::-1])}{a}")