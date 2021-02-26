import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(lambda x:x.rstrip(), sys.stdin)

for i in S:
    tmp = i.lower()
    g = tmp.count('g')
    b = tmp.count('b')
    if g > b:
        print(f'{i} is GOOD')
    elif g < b:
        print(f'{i} is A BADDY')
    else:
        print(f'{i} is NEUTRAL')