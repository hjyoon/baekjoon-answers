import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A = int(input())
B = int(input())
C = B - A
if 1 <= C <= 20:
    print('You are speeding and your fine is $100.')
elif 21 <= C <= 30:
    print('You are speeding and your fine is $270.')
elif 31 <= C:
    print('You are speeding and your fine is $500.')
else:
    print('Congratulations, you are within the speed limit!')