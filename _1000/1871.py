import sys
sys.stdin = open("input.txt", 'r')

N, *S = map(lambda x: x.rstrip(), sys.stdin)

for i in S:
    a, b = i.split('-')
    a = a[::-1]
    a = list(map(lambda x:(ord(x[1])-65)*26**x[0] , enumerate(a)))
    print(f"{['not ', ''][abs(sum(a) - int(b)) <= 100]}nice")