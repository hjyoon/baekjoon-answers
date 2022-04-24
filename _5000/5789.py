import sys
sys.stdin = open("input.txt", 'r')

_, *S = map(lambda x: x.rstrip(), sys.stdin)

for i in S:
    print('Do-it' + ['', '-Not'][i[len(i)//2-1] != i[len(i)//2]])