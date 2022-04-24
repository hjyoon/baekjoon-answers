import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

T = int(input().rstrip())

for i in range(1, T+1):
    s1 = input().strip()
    s2 = input().strip()
    s1 = s1.lower()
    s2 = s2.lower()
    while True:
        tmp = s1.replace('  ', ' ')
        if s1 == tmp:
            break
        s1 = tmp
    while True:
        tmp = s2.replace('  ', ' ')
        if s2 == tmp:
            break
        s2 = tmp
    s1 = s1.replace(',', ';')
    s2 = s2.replace(',', ';')
    s1 = s1.replace('[', '(').replace('{', '(').replace(']', ')').replace('}', ')')
    s2 = s2.replace('[', '(').replace('{', '(').replace(']', ')').replace('}', ')')
    s1 = s1.replace('( ', '(').replace(' (', '(').replace(') ', ')').replace(' )', ')')
    s2 = s2.replace('( ', '(').replace(' (', '(').replace(') ', ')').replace(' )', ')')
    s1 = s1.replace('; ', ';').replace(' ;', ';').replace(': ', ':').replace(' :', ':').replace('. ', '.').replace(' .', '.')
    s2 = s2.replace('; ', ';').replace(' ;', ';').replace(': ', ':').replace(' :', ':').replace('. ', '.').replace(' .', '.')
    if s1 == s2:
        print(f'Data Set {i}: equal\n')
    else:
        print(f'Data Set {i}: not equal\n')