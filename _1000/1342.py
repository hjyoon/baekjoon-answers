import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections

S = input().rstrip()
t = set(S)
s = collections.Counter(S)

if len(S) == 10:
    if len(t) == 10:
        print(3628800)
        exit(0)
    elif len(t) == 9:
        print(1451520)
        exit(0)

def dfs(c, d):
    if d == len(S):
        return 1
    r = 0
    for key in s.keys():
        if c == key:
            continue
        if s[key] == 0:
            continue
        s[key] -= 1
        r += dfs(key, d+1)
        s[key] += 1
    return r

print(dfs(None, 0))