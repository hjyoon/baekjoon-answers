import sys
sys.stdin = open("input.txt", 'r')

*S, _ = map(lambda x: x.rstrip().lower(), sys.stdin)
for i in S:
    if 'nemo' in i:
        print('Found')
    else:
        print('Missing')