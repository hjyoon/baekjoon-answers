import sys
sys.stdin = open("input.txt", 'r')

_, *S= map(lambda x: x.rstrip(), sys.stdin)

c = set(map(chr, range(97, 123)))

# for i in S:
#     i = i.lower()
#     t = sorted(c-set(i))
#     if not t:
#         print('pangram')
#     else:
#         print('missing ' + ''.join(t))

def test(i):
    i = i.lower()
    t = sorted(c-set(i))
    if not t:
        print('pangram')
    else:
        print('missing ' + ''.join(t))

l = map(test, S)
for _ in l:
    pass

