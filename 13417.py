import sys
import re
import collections
import itertools
DEBUG = 1

TC = [
    {'data': [3, ['M', 'K', 'U']], 'AC': 'KMU'}, {'data': [5, ['A', 'S', 'D', 'F', 'G']], 'AC': 'ASDFG'},
    {'data': [7, ['B', 'A', 'C', 'A', 'B', 'A', 'C']], 'AC': 'AAABCBC'}
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    T = int(input().rstrip())
    for _ in range(T):
        N = int(input().rstrip())
        S = input().rstrip().split()

        data = [N, S]
        if DEBUG:
            ac = out_f.readline().rstrip()
            #ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
            l.append({'data':data, 'AC':ac})
        else:
            l.append({'data':data})

def solution(N, S):
    ans = None
    dq = collections.deque()
    for s in S:
        if len(dq) == 0:
            dq.append(s)
        else:
            if dq[0] >= s:
                dq.appendleft(s)
            else:
                dq.append(s)

    ans = ''.join(dq)
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