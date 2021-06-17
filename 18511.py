import sys
import re
import collections
import itertools
import bisect
DEBUG = 1

TC = [
    {'data': [657, 3, [1, 5, 7]], 'AC': '577'},
    {'data': [657, 2, [1, 5]], 'AC': '555'},
    {'data': [657, 1, [1]], 'AC': '111'},
    {'data': [657, 3, [5, 6, 7]], 'AC': '657'},
    {'data': [657, 2, [6, 7]], 'AC': '77'},
    {'data': [11, 1, [9]], 'AC': '9'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    #N, S = map(lambda x:x.rstrip(), in_f)
    N, K = map(int, input().rstrip().split())
    S = map(int, input().rstrip().split())

    data = [N, K, S]
    if DEBUG:
        ac = out_f.readline().rstrip()
        #ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(N, K, S):
    ans = 0
    tmp = []
    S = list(map(str, S))
    for i in range(1, len(str(N))+1):
        for v in itertools.product(S, repeat=i):
            tmp.append(int(''.join(v)))
    tmp.sort()
    ans = tmp[bisect.bisect(tmp, N)-1]
    
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