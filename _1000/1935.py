import sys
import re
import collections
import itertools
DEBUG = 1

TC = [
    {'data': [5, 'ABC*+DE/-', [1, 2, 3, 4, 5]], 'AC': '6.20'},
    {'data': [1, 'AA+A+', [1]], 'AC': '3.00'},
    {'data': [5, 'ABCD-*+E+', [7, 3, 5, 2, 4]], 'AC': '20.00'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    N = int(input().rstrip())
    S = input().rstrip()
    V = [int(input().rstrip()) for _ in range(N)]

    data = [N, S, V]
    if DEBUG:
        #ac = out_f.readline().rstrip()
        ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(N, S, V):
    ans = None
    dq = collections.deque()
    d = {}
    for i, v in enumerate(V, ord('A')):
        d[chr(i)] = v

    for v in S:
        if v.isalpha():
            dq.append(d[v])
        else:
            a = dq.pop()
            b = dq.pop()
            dq.append(eval(f'{b}{v}{a}'))
    ans = f'{dq[0]:.2f}'
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