import sys
sys.stdin = open("input.txt", 'r')

S = list(map(lambda x: x.rstrip().lower(), sys.stdin))

for i in S:
    print(i)
    if i == 'EOI':
        break
    if i.find('nemo') != -1:
        print('Found')
    else:
        print('Missing')