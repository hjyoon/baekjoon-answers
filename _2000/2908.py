import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A, B = map(lambda x:int(x[::-1]), input().split())
print(max(A, B))