import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

a, b, c, d = map(int, input().rstrip().split())

print(a*56 + b*24 +  c*14 + d*6)