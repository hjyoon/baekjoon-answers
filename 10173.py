import sys
#sys.stdin = open("input.txt", 'r')

*S, _ = map(lambda x: x.rstrip().lower(), sys.stdin)
for i in S:
    if i.find('nemo') != -1:
        print('Found')
    else:
        print('Missing')