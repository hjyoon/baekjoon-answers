import sys
from pprint import pprint
sys.stdin = open('input.txt')
input = sys.stdin.readline


def dfs(ay, by, cy, ax, bx, cx, l):
    if sum([ay, by, cy, ax, bx, cx]) == 0:
        # 가능
        ans = map(lambda x: x[1:], sorted(l))
        print(1)
        for v in ans:
            print(*v)
        exit()
        return

    # ay 기준
    if ay > 0:
        if ay > bx + cx:
            return
        else:
            if ay == bx + cx:
                l.append(['A', bx, cx])
                dfs(0, by, cy, ax, 0, 0, l)
                l.pop()
            else:
                # bx 에 먼저 할당
                if ay >= bx:
                    l.append(['A', bx, ay-bx])
                    dfs(0, by, cy, ax, 0, cx-(ay-bx), l)
                    l.pop()
                else:
                    l.append(['A', ay, 0])
                    dfs(0, by, cy, ax, bx-ay, cx, l)
                    l.pop()

                # cx 에 먼저 할당
                if ay >= cx:
                    l.append(['A', ay-cx, cx])
                    dfs(0, by, cy, ax, bx-(ay-cx), 0, l)
                    l.pop()
                else:
                    l.append(['A', 0, ay])
                    dfs(0, by, cy, ax, bx, cx-ay, l)
                    l.pop()

    # by 기준
    if by > 0:
        if by > ax + cx:
            return
        else:
            if by == ax + cx:
                l.append(['B', ax, cx])
                dfs(ay, 0, cy, 0, bx, 0, l)
                l.pop()
            else:
                # ax 에 먼저 할당
                if by >= ax:
                    l.append(['B', ax, by-ax])
                    dfs(ay, 0, cy, 0, bx, cx-(by-ax), l)
                    l.pop()
                else:
                    l.append(['B', by, 0])
                    dfs(ay, 0, cy, ax-by, bx, cx, l)
                    l.pop()

                # cx 에 먼저 할당
                if by >= cx:
                    l.append(['B', by-cx, cx])
                    dfs(ay, 0, cy, ax-(by-cx), bx, 0, l)
                    l.pop()
                else:
                    l.append(['B', 0, by])
                    dfs(ay, 0, cy, ax, bx, cx-by, l)
                    l.pop()

    # cy 기준
    if cy > 0:
        if cy > ax + bx:
            return
        else:
            if cy == ax + bx:
                l.append(['C', ax, bx])
                dfs(ay, by, 0, 0, 0, cx, l)
                l.pop()
            else:
                # ax 에 먼저 할당
                if cy >= ax:
                    l.append(['C', ax, cy-ax])
                    dfs(ay, by, 0, 0, bx-(cy-ax), cx, l)
                    l.pop()
                else:
                    l.append(['C', cy, 0])
                    dfs(ay, by, 0, ax-cy, bx, cx, l)
                    l.pop()

                # bx 에 먼저 할당
                if cy >= bx:
                    l.append(['C', cy-bx, bx])
                    dfs(ay, by, 0, ax-(cy-bx), 0, cx, l)
                    l.pop()
                else:
                    l.append(['C', 0, cy])
                    dfs(ay, by, 0, ax, bx-cy, cx, l)
                    l.pop()


N = int(input())
ay, ax = map(int, input().split())
by, bx = map(int, input().split())
cy, cx = map(int, input().split())

dfs(ay, by, cy, ax, bx, cx, [])
print(0)
