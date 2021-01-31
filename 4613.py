import sys
sys.stdin = open("input.txt", 'r')

*S, _ = map(lambda x:x.rstrip(), sys.stdin)

l = map(chr, range(65, 91))
v = map(int, range(1, 27))
m = dict(map(lambda x:(x[0], x[1]), zip(l, v)))
m[' '] = 0

for i in S:
    tmp = map(lambda x:(x[0]+1)*m[x[1]], enumerate(i))
    print(sum(tmp))