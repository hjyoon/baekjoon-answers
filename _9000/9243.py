import sys
sys.stdin = open("input.txt", 'r')

N, *S = map(lambda x: x.rstrip(), sys.stdin)
N = int(N)

# fail = False
# if N%2 == 1:
#     for i in range(len(S[0])):
#         if S[0][i] == S[1][i]:
#             fail = True
#             break
# else:
#     if S[0] != S[1]:
#         fail = True

# if fail:
#     print('Deletion failed')
# else:
#     print('Deletion succeeded')

x, y = map(lambda x: int(x, base=2), S)

if N%2 == 0:
    if x == y:
        print('Deletion succeeded')
    else:
        print('Deletion failed')
else:
    z = bin(x ^ y)[2:]
    if z == '1'*len(z):
        print('Deletion succeeded')
    else:
        print('Deletion failed')