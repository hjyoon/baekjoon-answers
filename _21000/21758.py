import sys

input = sys.stdin.readline


def solve():
    input()
    S = list(map(int, input().split()))
    candidates = []

    prefixSum = [0] * len(S)
    prefixSum[0] = S[0]
    for i in range(1, len(S)):
        prefixSum[i] = prefixSum[i - 1] + S[i]

    for i in range(1, len(S) - 1):
        tmp = (prefixSum[-1] - prefixSum[0] - S[i]) + (prefixSum[-1] - prefixSum[i])
        candidates.append(tmp)

    for i in range(len(S) - 2, 0, -1):
        tmp = (prefixSum[-2] - S[i]) + prefixSum[i - 1]
        candidates.append(tmp)

    maxIdx = 0
    maxVal = 0
    for i in range(1, len(S) - 1):
        if maxVal < S[i]:
            maxIdx = S[i]
            maxIdx = i

    candidates.append(sum(S[1 : maxIdx + 1]) + sum(S[-2 : maxIdx - 1 : -1]))

    ans = max(candidates)
    print(ans)


solve()
