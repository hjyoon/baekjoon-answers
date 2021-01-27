import sys
sys.stdin = open("input.txt", 'r')

_, *S = map(lambda x: tuple(x.split()), sys.stdin)

# for i in S:
#     res = []
#     for j in range(len(i[0])):
#         res.append(str((ord(i[1][j])-ord(i[0][j])+26)%26))
#     print(f'Distances: {" ".join(res)}')

# input()
# for a, b in zip(*input().split()):
#     print((ord(b)-ord(a)+26)%26)

# for i in S:
#     res = list(map(tuple, zip(*i)))
#     print(res)

res = list(map(lambda x: list(zip(*x)), S))
res = list(map(lambda x: list(map(lambda y: (ord(y[1])-ord(y[0])+26)%26, x)), res))
for i in res:
    print(f'Distances: {" ".join(map(str, i))}')