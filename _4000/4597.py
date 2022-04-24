import sys
sys.stdin = open("input.txt", 'r')

*S, _ = map(lambda x: x.rstrip(), sys.stdin)

for i in S:
    if i[-1] == 'e':
        print(i[:-1] + '10'[i.count('1') % 2 == 0])
    else:
        print(i[:-1] + '01'[i.count('1') % 2 == 0])