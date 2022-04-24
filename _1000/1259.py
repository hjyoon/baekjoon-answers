import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

*S, _ = map(lambda x: x.rstrip(), sys.stdin)

for s in S:
    if s == s[::-1]:
        print('yes')
    else:
        print('no')
