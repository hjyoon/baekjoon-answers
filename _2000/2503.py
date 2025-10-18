import sys


def check(rule, num):
    s = set()
    strike, ball = 0, 0
    for i in range(3):
        if rule[0][i] == num[i]:
            strike += 1
        else:
            if rule[0][i] in s:
                ball += 1
            else:
                s.add(rule[0][i])
            if num[i] in s:
                ball += 1
            else:
                s.add(num[i])
    if strike == rule[1] and ball == rule[2]:
        return True
    else:
        return False


def solve():
    visited = [False] * 10
    l = []
    ans = 0

    N = int(sys.stdin.readline())
    rules = []
    for _ in range(N):
        t, s, b = sys.stdin.readline().split()
        s, b = int(s), int(b)
        rules.append([t, s, b])

    def dfs():
        nonlocal ans
        if len(l) == 3:
            num = "".join(map(str, l))
            for rule in rules:
                if not check(rule, num):
                    break
            else:
                ans += 1
            return
        else:
            for i in range(1, 10):
                if not visited[i]:
                    visited[i] = True
                    l.append(i)
                    dfs()
                    l.pop()
                    visited[i] = False

    dfs()

    print(ans)


solve()
