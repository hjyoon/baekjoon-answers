import sys
sys.stdin = open("input.txt", 'r')

country = ['botswana', 'ethiopia', 'kenya', 'namibia', 'south-africa', 'tanzania', 'zambia', 'zimbabwe']
visa = [0, 50, 50, 140, 0, 50, 50, 30]
d = dict(zip(country, visa))

_, *S = map(lambda x: x.rstrip(), sys.stdin)

sum = 0;
for i in S:
    sum += d[i]
    if i == 'south-africa':
        d['namibia'] = 40
        d['zambia'] = 50
        d['zimbabwe'] = 30
    elif i == 'zambia':
        d['zimbabwe'] = 0
    elif i == 'zimbabwe':
        d['zambia'] = 20
    else:
        d['zambia'] = 50
        d['zimbabwe'] = 30

print(sum)