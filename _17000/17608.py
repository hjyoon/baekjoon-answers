import sys
import re
import collections
import itertools
import bisect
DEBUG = 1

TC = [
    {'data': ['6', [6, 9, 7, 6, 4, 6]], 'AC': '3'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    N, *S = map(lambda x:x.rstrip(), in_f)
    S = list(map(int, S))
    #N, K = map(int, input().rstrip().split())
    #S = map(int, input().rstrip().split())

    data = [N, S]
    if DEBUG:
        #ac = out_f.readline().rstrip()
        ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(N, S):
    ans = 0
    tmp = 0
    for v in reversed(S):
        if v > tmp:
            ans += 1
            tmp = v
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