import math
import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline


def gcd(a, b):
    a_set = set()
    b_set = set()
    for n in range(1, int(a**0.5)+1):
        q, r = divmod(a, n)
        if r == 0:
            a_set.add(n)
            a_set.add(q)

    for n in range(1, int(b**0.5)+1):
        q, r = divmod(b, n)
        if r == 0:
            b_set.add(n)
            b_set.add(q)

    return max(a_set.intersection(b_set))


def lcm(a, b):
    return a*b//gcd(a, b)


A, B = map(int, input().split())

# print(math.gcd(A, B))  # 최대공약수
# print(math.lcm(A, B))  # 최소공배수

print(gcd(A, B))
print(lcm(A, B))
