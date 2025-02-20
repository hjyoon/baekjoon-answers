import sys
import collections


def solve():
    input = sys.stdin.readline

    input()
    S = tuple(map(int, input().rstrip().split()))

    l, r = 0, 0
    s = set([S[l]])
    d = collections.defaultdict(int)
    d[S[l]] += 1
    ans = 0
    while True:
        while len(s) > 2:
            if d[S[l]] > 0:
                d[S[l]] -= 1
            if d[S[l]] == 0:
                s.remove(S[l])
            l += 1
        ans = max(ans, r - l + 1)
        r += 1
        if r >= len(S):
            break
        s.add(S[r])
        d[S[r]] += 1

    print(ans)


solve()
