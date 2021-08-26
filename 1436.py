import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline


N = int(input())  # 최대 10,000

cnt = 0
num = 665
while cnt != N:
    num += 1
    if '666' in str(num):
        cnt += 1
print(num)
