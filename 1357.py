import sys
sys.stdin = open("input.txt", 'r')

print(int(str(sum(map(lambda x: int(x[::-1]), input().split())))[::-1]))