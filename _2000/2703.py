import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

T = int(input())
for i in range(T):
    s = input().rstrip()
    l = input().rstrip()
    #print(s.translate(''.maketrans('ABCDEFGHIJKLMNOPQRSTUVWXYZ', l)))
    #print(s.translate(''.maketrans(''.join([chr(i) for i in range(65, 91)]), l)))
    #print(s.translate(''.maketrans(''.join(map(chr, range(65, 91))), l)))

    d = dict(zip(map(chr, range(65, 91)), l))
    d[' '] = ' '
    res = ''.join(map(lambda x:d[x], s))
    print(res)