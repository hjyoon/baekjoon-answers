import sys

input = sys.stdin.readline


def solve():
    input()
    S = sorted(map(int, input().rstrip().split()))

    if len(S) < 3:
        print(0)
        return

    ans = 0

    def isGood(target_idx):
        l = 0
        r = len(S) - 1
        while True:
            if l == target_idx:
                l += 1
            if r == target_idx:
                r -= 1
            if l >= r:
                break
            if S[l] + S[r] > S[target_idx]:
                r -= 1
            elif S[l] + S[r] < S[target_idx]:
                l += 1
            else:
                print(l, r, target_idx)
                return True
        return False

    for i in range(len(S)):
        if isGood(i):
            ans += 1

    print(ans)


solve()
