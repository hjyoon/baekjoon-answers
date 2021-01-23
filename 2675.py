import sys
sys.stdin = open("input.txt", 'r')

T = int(input())

for i in range(T):
    a = input().split()
    times = int(a[0])
    for j in a[1]:
        print(j*times, end='')
    print()