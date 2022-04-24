import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import re
while True:
    i = input()
    if i == '#':
        break
    i = i.lower()
    i = re.sub("[^a-z]", "", i)
    s = set(i)
    print(len(s))
    #print(s)
