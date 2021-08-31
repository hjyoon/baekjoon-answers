from pprint import pprint
import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline


def cal_bin(a, b, carry):
    if len(a) == 0 and len(b) == 0:
        if carry == 1:
            print(1, end='')
        return

    tmp_a = a[-1]
    tmp_b = b[-1]

    tmp = int(tmp_a) + int(tmp_b) + carry

    if tmp == 3:
        cal_bin(a[:-1], b[:-1], 1)
        print(1, end='')
    elif tmp == 2:
        cal_bin(a[:-1], b[:-1], 1)
        print(0, end='')
    elif tmp == 1:
        cal_bin(a[:-1], b[:-1], 0)
        print(1, end='')
    else:
        cal_bin(a[:-1], b[:-1], 0)
        print(0, end='')


A, B = map(lambda x: x.lstrip('0').rstrip(), input().rstrip().split())

if len(A) > len(B):
    B = '0'*(len(A)-len(B)) + B
elif len(A) < len(B):
    A = '0'*(len(B)-len(A)) + A
else:
    pass

if A == '' and B == '':
    print(0)
else:
    cal_bin(A, B, 0)
