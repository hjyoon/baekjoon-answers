import sys
import re
import collections
import itertools
import math
DEBUG = 1

TC = [
    {'data': [2, ['<<BP<A>>Cd-', 'ThIsIsS3Cr3t']], 'AC': 'BAPC\nThIsIsS3Cr3t'},
    {'data': [1, ['<<BP<A>>Cd--']], 'AC': 'BAP'},
    {'data': [1, ['<<BP<A>>Cd']], 'AC': 'BAPCd'},
    {'data': [1, ['BP<A>C<d']], 'AC': 'BAPdC'},
    {'data': [1, ['AB<<C']], 'AC': 'CAB'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    #N, S = map(lambda x:x.rstrip(), in_f)
    T = int(input().rstrip())
    C = []
    for _ in range(T):
        S = input().rstrip()
        C.append(S)

    data = [T, C]
    if DEBUG:
        #ac = out_f.readline().rstrip()
        ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})
    

def solution(T, C):
    ans = []
    for s in C:
        left = []
        right = []
        for c in s:
            if str.isalnum(c):
                left.append(c)
            else:
                if c == '-':
                    if left:
                        left.pop()
                    else:
                        pass
                elif c == '<':
                    if left:
                        right.append(left.pop())
                    else:
                        pass
                elif c == '>':
                    if right:
                        left.append(right.pop())
                    else:
                        pass
        ans.append(''.join(left) + ''.join(right[::-1]))

    return ans_to_str(ans)

def ans_to_str(ans):
    if type(ans) == list:
        return '\n'.join(map(str, ans))
    elif type(ans) != str:
        return str(ans)
    else:
        return ans

def main():
    if DEBUG:
        print_data()
        #print(TC)
        pass
    else:
        TC.clear()
        read_data(TC, sys.stdin)
        #read_data(TC, open('input.txt', 'r'))

    for i, v in enumerate(TC, 1):
        res = solution(*v['data'])
        if DEBUG:
            if res == v['AC']:
                print(f'case #{i}: OK')
            else:
                print(f'case #{i}: ERR')
                print('accepted:')
                print(v['AC'])
                print('wrong answer:')
                print(res)
        else:
            print(res)

def print_data():
    with open("input.txt", 'r') as in_f, open("output.txt", 'r') as out_f:
        tmp = []
        read_data(tmp, in_f, out_f)
        print(tmp)

if __name__ == "__main__":
    main()