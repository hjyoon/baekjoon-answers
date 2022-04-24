import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools

N = int(input().rstrip())
for _ in range(N):
    S = sorted(map(int, input().rstrip().split()[1:]))
    ans = None
    for key, group in itertools.groupby(S):
        #print(key, list(group))
        if len(list(group)) > len(S)//2:
            ans = key
    if ans == None:
        ans = 'SYJKGW'
    print(ans)