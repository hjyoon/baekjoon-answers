import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(lambda x:x.rstrip(), sys.stdin)
for v in S:
    if v.startswith('Simon says'):
        print(v[10:])