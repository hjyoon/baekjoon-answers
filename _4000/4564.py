import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import functools
*S, _ = map(lambda x:x.rstrip(), sys.stdin)
for i in S:
    while True:
        if len(i) == 1:
            print(i)
            break
        else:
            print(i, end=' ')
        i = str(functools.reduce(lambda x,y:int(x)*int(y), i))