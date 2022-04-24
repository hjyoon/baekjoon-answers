import sys
from collections import deque
input = sys.stdin.readline

S = input().rstrip()

ans = deque()
ans.append(S[0])
for i in range(1, len(S)):
    if S[i] <= ans[0]:
        ans.appendleft(S[i])
    else:
        ans.append(S[i])
        
print(*ans, sep='')