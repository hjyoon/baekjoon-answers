import sys
sys.stdin = open("input.txt", 'r')

N = int(input())
X = input().split()
X = set(X)
print(int(N)-len(X))