import sys
sys.stdin = open("input.txt", 'r')

N, *S = map(lambda x:x.rstrip(), sys.stdin)

s = set()
for i in S:
    i = i.split(' ')
    if i[1] == 'enter':
        s.add(i[0])
    else:
        s.discard(i[0])
print('\n'.join(sorted(s, reverse=True)))