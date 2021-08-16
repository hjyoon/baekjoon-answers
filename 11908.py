import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

N = int(input())
S = list(map(int, input().split()))

print(sum(S) - max(S))