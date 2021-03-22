import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

H = input().rstrip()
N = input().rstrip()

print(H.count(N))