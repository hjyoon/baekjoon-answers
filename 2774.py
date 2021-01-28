import sys
sys.stdin = open("input.txt", 'r')

T, *X = map(lambda x: x.rstrip(), sys.stdin)

for x in X:
    print(len(set(x)))