import sys
sys.stdin = open("input.txt", 'r')

S = input()
a = S.count(':-)')
b = S.count(':-(')
if a == 0 and b == 0:
    print('none')
elif a == b:
    print('unsure')
elif a > b:
    print('happy')
else:
    print('sad')