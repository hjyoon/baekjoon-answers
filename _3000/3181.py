import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

e = ['i', 'pa', 'te', 'ni', 'niti', 'a', 'ali', 'nego', 'no', 'ili']

A, *S = input().split()
S = filter(lambda x:x not in e, S)
S = map(lambda x:x[0].upper(), S)
print(A[0].upper() + ''.join(list(S)))