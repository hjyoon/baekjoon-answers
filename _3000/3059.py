import sys
sys.stdin = open("input.txt", 'r')

# ascii = dict(map(lambda x: (chr(x), x), range(65, 91))) # ['A', 'B', ... , 'Y', 'Z']

_, *S = map(lambda x: x.rstrip(), sys.stdin)
for i in S:
    sum = 0
    for j in map(chr, range(65, 91)):
        if j not in i:
            sum += ord(j)
    print(sum)