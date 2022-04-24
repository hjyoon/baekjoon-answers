import sys
sys.stdin = open("input.txt", 'r')

_, *S = map(lambda x: x.rstrip(), sys.stdin)
for i in S:
    print(f'{i[0]}{i[-1]}')