import sys
sys.stdin = open("input.txt", 'r')

_, *S = map(lambda x: x.rstrip(), sys.stdin)
for i, v in enumerate(S):
    print(f'{i+1}. {v}')
