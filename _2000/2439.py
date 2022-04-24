import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input())
for i in range(1, N+1):
    print(f"{' '*(N-i)}{'*'*i}")