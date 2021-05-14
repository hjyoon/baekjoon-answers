import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A, B = map(str, input().rstrip().split())

print(sum(map(int, A)) * sum(map(int, B)))