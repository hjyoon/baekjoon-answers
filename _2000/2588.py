import sys
sys.stdin = open("input.txt", 'r')

a = int(input())
b = input()
c = list(map(int, b))
for i in range(3):
    print(a * c[2-i])

print(a * int(b))
