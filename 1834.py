import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input())
sum = 0
for i in range(1, N):
    sum += N*i+i
print(sum)