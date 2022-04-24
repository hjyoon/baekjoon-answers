import math
from decimal import Decimal
from pprint import pprint
import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline


def cal(dist):
    step2 = Decimal(dist) / Decimal(K)
    step3 = math.ceil(step2)
    return step3


K, A, B = map(int, input().split())
if A <= 0 <= B:
    res = cal(abs(A) + 1) + cal(abs(B) + 1) - 1
elif 0 <= A <= B:
    res = cal(abs(B) + 1) - cal(abs(A))
else:
    res = cal(abs(A) + 1) - cal(abs(B))
print(res)
