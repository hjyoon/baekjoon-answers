import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import re
N = int(input())

import collections
for i in range(N):
    S = re.sub('[^a-z]', '', input().lower())
    print(S)
    t = list(map(int, collections.Counter(S).values()))
    print(f'Case {i+1}: ', end='')
    if len(t) < 26:
        print('Not a pangram')
    elif len(list(filter(lambda x:x>=3, t))) == 26:
        print('Triple pangram!!!')
    elif len(list(filter(lambda x:x>=2, t))) == 26:
        print('Double pangram!!')
    else:
        print('Pangram!')