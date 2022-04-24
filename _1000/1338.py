from pprint import pprint
import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline


A, B = map(int, input().split())
X, Y = map(int, input().split())

i = 0
while -(2**16) <= i*X+Y <= (2**16)-1:
    print(i*X+Y)
    if A <= i*X+Y <= B:
        print(i)
    i += 1
