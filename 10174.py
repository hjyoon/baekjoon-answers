import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

T, *S = map(lambda x:x.rstrip(), sys.stdin)
for i in S:
    i = i.lower()
    if i == i[::-1]:
        print('Yes')
    else:
        print('No')