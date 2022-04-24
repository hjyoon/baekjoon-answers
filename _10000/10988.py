import sys
sys.stdin = open("input.txt", 'r')

s = input()

if s == s[::-1]:
    print(1)
else:
    print(0)