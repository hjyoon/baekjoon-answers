import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_ = input()
A = set(input().split())
B = set(input().split())
print(len(A^B))