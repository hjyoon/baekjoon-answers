import sys


def solve():
    input = sys.stdin.readline
    N = int(input())
    P = list(map(int, input().rstrip().split()))
    S = list(map(int, input().rstrip().split()))

    target = [0, 1, 2] * (N // 3)

    if P == target:
        print(0)
        return

    now = P[::]

    ans = 1
    while True:
        tmp = [-1] * N
        for i in range(N):
            tmp[S[i]] = now[i]
        now = tmp
        if now == P:
            print(-1)
            return
        if now == target:
            break
        ans += 1

    print(ans)


solve()
