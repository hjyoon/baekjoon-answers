import sys
sys.stdin = open("input.txt", 'r')

S = list(map(lambda x: x.rstrip(), sys.stdin))
S = list(filter(lambda x: x[1].find('FBI') != -1 ,enumerate(S)))
S = list(map(lambda x: x[0]+1 ,S))

if not S:
    print('HE GOT AWAY!')
else:
    print(*S)