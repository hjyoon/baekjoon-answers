import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, T = map(int, input().split())

l = [i for i in range(1, N*2)] + [i for i in range(N*2, 1, -1)]

length = (N*2) + (N*2) - 2
target = T - 1

print(l[target % length])