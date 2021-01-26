import sys
sys.stdin = open("input.txt", 'r')

l = list(map(lambda x:int(x.strip()), sys.stdin))
l2 = []
for i, v in enumerate(l):
    l2.append((v, i+1))

l2.sort(reverse=True)
l3 = l2[:5]
l3.sort(key=lambda x:x[1])
l4 = list(map(lambda x:x[0], l3))
print(sum(l4))
l5 = list(map(lambda x:str(x[1]), l3))
print(' '.join(l5))