import sys
sys.stdin = open("input.txt", 'r')

*S, _ = map(lambda x: x.rstrip(), sys.stdin)

import re

c = set(map(chr, range(97, 123)))
for i in S:
    #i = re.sub(' +', '', i)
    i.replace(' ', '')
    d = False
    for j in c:
        if j not in i:
            d = True
            break;
    print(['Y','N'][d])