import sys
sys.stdin = open("input.txt", 'r')

#a = input().split(' ')
#print(int(a[0])+int(a[1]))

a = set(map(int, input().split()))
print(a)