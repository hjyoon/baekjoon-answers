import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections

N, S = map(int, input().rstrip().split())
A = collections.deque(sorted(map(int, sys.stdin)))

c = 0
i = 0
while True:
    if len(A) == 0:
        break
    left = 0
    right = len(A) - 1
    mid = 0
    res = 0
    def chk():
        if A[mid] + A[0] > S:
            return True
        else:
            return False
    while left <= right:
        mid = (left + right) // 2
        if chk():
            right = mid - 1
        else :
            left = mid + 1
            res = mid
    c += res
    A.popleft()
print(c)