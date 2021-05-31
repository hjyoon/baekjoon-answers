import sys
import re
import collections
import itertools
DEBUG = 1

TC = [
    {'data': ['There is no cow level', 5, [1, 0, 2, 0, 4, 3, 0, 1, 2, 0, 0, 3, 0, 2, 2, 0, 4, 1, 1, 2, 0, 1, 1, 0, 0, 0]], 'AC': 'TINCL'},
    {'data': ['Show me the money', 2, [0, 1, 0, 4, 3, 0, 0, 2, 0, 0, 0, 0, 4, 1, 2, 0, 0, 0, 1, 2, 0, 0, 1, 0, 1, 2]], 'AC': '-1'},
    {'data': ['show me the money', 4, [1, 0, 3, 2, 1, 0, 0, 2, 0, 0, 0, 0, 4, 1, 2, 0, 0, 0, 1, 2, 0, 0, 1, 0, 1, 0]], 'AC': '-1'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    S = input().rstrip()
    W = int(input().rstrip())
    C = list(map(int, input().rstrip().split()))

    data = [S, W, C]
    if DEBUG:
        ac = out_f.readline().rstrip()
        #ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(S, W, C):
    ans = None
    ans = ''.join(map(lambda x:x[0].upper(), S.split()))
    S += ans
    
    d = {' ':W}
    for i, v in enumerate(C, ord('A')):
        d[chr(i)] = v

    pre = None
    for s in S:
        s = s.upper() if s.isalpha() else s
        if s == pre:
            continue
        if d[s] > 0:
            d[s] -= 1
            pre = s
        else:
            ans = -1
            break

    return str(ans) if type(ans) != str else ans

def main():
    if DEBUG:
        #print_data()
        #print(TC)
        pass
    else:
        TC.clear()
        read_data(TC, sys.stdin)

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