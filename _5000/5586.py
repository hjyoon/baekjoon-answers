import sys
sys.stdin = open("input.txt", 'r')

S = input()
S = list(zip(S, S[1:], S[2:]))
print(S.count(('J', 'O', 'I')))
print(S.count(('I', 'O', 'I')))