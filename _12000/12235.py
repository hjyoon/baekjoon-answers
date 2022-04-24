import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections

T = int(input().rstrip())
for i in range(T):
    N, X = map(int, input().rstrip().split())
    S = sorted(map(int, input().rstrip().split()))
    S = collections.deque(S)
    r = 0
    while True:
        if len(S) == 0:
            break
        if len(S) >= 2:
            a = S.popleft()
            b = S.pop()
            if a + b <= X:
                r += 1
            else:
                S.appendleft(a)
                r += 1
        else:
            S.pop()
            r += 1
    print(f'Case #{i+1}: {r}')