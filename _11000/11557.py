import sys
sys.stdin = open("input.txt", 'r')

T = int(input())

for t in range(T):
    N = int(input())
    max = 0
    name = ''
    for i in range(N):
        s = input().split()
        if int(s[1]) > max:
            max = int(s[1])
            name = s[0]

    print(name)