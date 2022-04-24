import sys
import bisect
import collections
from pprint import pprint
sys.stdin = open('input.txt')
input = sys.stdin.readline


def sieve_of_eratosthenes(n):
    seive = [False, False] + [True] * (n - 1)
    for k in range(2, int(n ** 0.5 + 1.5)):
        if seive[k]:
            seive[k*2::k] = [False] * ((n - k) // k)
    return [x for x in range(n+1) if seive[x]]


# 범위 내의 소수 가져오기
def get_prime_list(prime_numbers, a, b):
    start = bisect.bisect_left(prime_numbers, a)
    end = bisect.bisect_right(prime_numbers, b)
    return prime_numbers[start:end]


# 소수 리스트 2 ~ 100000
prime_numbers = sieve_of_eratosthenes(100000)


def bfs(root):
    visit = [None] * (1000000+1)
    dq = collections.deque()
    dq.append((root, 0))
    while dq:
        # print(dq)
        n, cnt = dq.popleft()
        if n > 1000000 or n < 0:
            continue
        if visit[n] != None:
            continue
        visit[n] = cnt
        dq.append((n//2, cnt+1))
        dq.append((n//3, cnt+1))
        dq.append((n+1, cnt+1))
        dq.append((n-1, cnt+1))
    return visit


T = int(input())
for _ in range(T):
    N, A, B = map(int, input().split())
    print(N, A, B)
    print(get_prime_list(prime_numbers, A, B))
    print(bfs(N)[:30])
