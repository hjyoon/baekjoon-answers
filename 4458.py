import sys
sys.stdin = open("input.txt", 'r')

_, *S = map(lambda x: x[0].upper()+x[1:].rstrip(), sys.stdin)
print('\n'.join(S))