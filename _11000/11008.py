import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(lambda x:x.rstrip(), sys.stdin)

for v in S:
    s, p = v.split()
    c = s.count(p)
    print(len(s)-c*len(p)+c)