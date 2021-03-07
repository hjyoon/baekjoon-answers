import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = map(lambda x:x.rstrip(), sys.stdin)

import itertools

for v in S:
    a, b = v.split()
    b = int(b)
    l = itertools.permutations(a)
    j = 1
    for i in l:
        if j == b:
            print(f"{v} = {''.join(i)}")
            break
        j += 1
    if j < b:
        print(f'{v} = No permutation')


    # if len(l) < b:
    #     print(f'{v} = No permutation')
    # else:
    #     print(f'{v} = {"".join(l[b-1])}')