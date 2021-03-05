import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import re

while True:
    s = input().rstrip()
    if s == '#':
        break;
    m = re.search('[aeiou]', s)
    if m == None:
        print(f'{s}ay')
    else:
        i = m.start()
        print(f'{s[i:]}{s[:i]}ay')