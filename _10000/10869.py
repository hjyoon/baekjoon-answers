import sys
sys.stdin = open("input.txt", 'r')

a, b = map(int, input().split())
print(a+b,a-b,a*b,a//b,a%b,sep='\n')