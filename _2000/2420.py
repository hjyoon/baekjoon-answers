import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A, B = map(int, input().split())
print(abs(A-B))