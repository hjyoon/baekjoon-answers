import sys
import math
input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
S = list(map(int, input().rstrip().split()))


def check(size):
    global M
    tmp = 0
    cnt = 1
    for v in S:
        tmp += v
        if tmp > size:
            tmp = v
            cnt += 1
            if cnt > M:
                return False
    return True


hap = sum(S)
tmp_max = max(S)
left, right = max(int(math.ceil(hap/M)), tmp_max), hap
mid = 0
while True:
    mid = (left + right) // 2
    # print(left, right, mid, check(mid))
    if left >= right:
        break
    if check(mid):
        right = mid
    else:
        left = mid + 1

print(mid)
