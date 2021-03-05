import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_ = input()
A = set(map(int, input().split()))
B = set(map(int, input().split()))
res = sorted(A-B)
print(len(res))
print(*res)