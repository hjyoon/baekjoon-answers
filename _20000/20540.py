import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = input().rstrip()

for i in range(4):
    if S[i] == 'E':
        print('I', end='')
    elif S[i] == 'I':
        print('E', end='')
    elif S[i] == 'N':
        print('S', end='')
    elif S[i] == 'S':
        print('N', end='')
    elif S[i] == 'T':
        print('F', end='')
    elif S[i] == 'F':
        print('T', end='')
    elif S[i] == 'P':
        print('J', end='')
    elif S[i] == 'J':
        print('P', end='')