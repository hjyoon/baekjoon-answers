import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S1, S2 = map(int, input().split())

for i in range(S1):
    a, b = map(int, input().split())
    if a != b:
        print('Wrong Answer')
        exit()

for i in range(S2):
    a, b = map(int, input().split())
    if a != b:
        print('Why Wrong!!!')
        exit()

print('Accepted')
