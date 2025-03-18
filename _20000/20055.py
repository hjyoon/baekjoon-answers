import sys


def solve():
    input = sys.stdin.readline
    N, K = map(int, input().rstrip().split())
    A = list(map(int, input().rstrip().split()))

    ans = 0
    start = 0
    end = N - 1

    robots_pos = []

    while True:
        ans += 1

        start = (start - 1) % (N * 2)
        end = (end - 1) % (N * 2)

        for i in range(len(robots_pos)):
            if robots_pos[i] == end:
                robots_pos[i] = -1
                continue
            tmp = (robots_pos[i] + 1) % (N * 2)
            if A[tmp] > 0 and tmp not in robots_pos:
                A[tmp] -= 1
                if tmp == end:
                    robots_pos[i] = -1
                    continue
                robots_pos[i] = tmp

        robots_pos = [x for x in robots_pos if x != -1]

        if A[start] > 0 and start not in robots_pos:
            A[start] -= 1
            robots_pos.append(start)

        if A.count(0) >= K:
            break

    print(ans)


solve()
