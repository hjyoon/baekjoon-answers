from pprint import pprint
import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline


def solve(cur, fr, to, ac):
    global ans

    if fr > N:
        ans = min(ans, ac)
        return

    for i in range(fr, to+1):
        tmp_sum = 0
        for j in range(fr, i+1):
            tmp_sum += C[j]
        solve(cur+1, i+1, N, ac + tmp_sum*(cur+i))


while True:
    N = int(input())
    if N == 0:
        break
    C = [None] + list(map(int, input().split()))
    # print(C)
    ans = float('inf')
    solve(1, 1, N, 0)
    print(ans)
