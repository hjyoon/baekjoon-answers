import sys
sys.stdin = open("input.txt", 'r')

a, b = map(int, input().split())
c = int(input())

total = (a*60 + b + c)%1440

print(total//60, total%60)