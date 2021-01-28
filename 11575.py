import sys
sys.stdin = open("input.txt", 'r')

# T = int(input())
# for _ in range(T):
#     A, B = map(int, input().split())
#     S = input()
#     res = list(map(lambda x: chr((A*(ord(x)-65)+B)%26+65), S))
#     print(''.join(res))

T = int(input())
for _ in range(T):
    A, B = map(int, input().split())
    S = input()

    tmp = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    #print(S.translate(''.maketrans(tmp, ''.join(tmp[(A*i+B)%26]for i in range(26)))))
    print(S.translate(''.maketrans(tmp, ''.join(map(lambda x: tmp[(A*x+B)%26], range(26))))))