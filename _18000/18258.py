import sys
import re
import collections
import itertools
import bisect
DEBUG = 1

TC = [
    {'data': ['15', ['push 1', 'push 2', 'front', 'back', 'size', 'empty', 'pop', 'pop', 'pop', 'size', 'empty', 'pop', 'push 3', 'empty', 'front']], 'AC': '1\n2\n2\n0\n1\n2\n-1\n0\n1\n-1\n0\n3'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    N, *S = map(lambda x:x.rstrip(), in_f)
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
    ans = []
    dq = collections.deque()
    for v in S:
        v = v.split()
        if v[0] == 'push':
            dq.append(v[1])
        elif v[0] == 'pop':
            if dq:
                ans.append(dq.popleft())
            else:
                ans.append('-1')
        elif v[0] == 'front':
            if dq:
                ans.append(dq[0])
            else:
                ans.append('-1')
        elif v[0] == 'back':
            if dq:
                ans.append(dq[-1])
            else:
                ans.append('-1')
        elif v[0] == 'size':
            ans.append(str(len(dq)))
        elif v[0] == 'empty':
            if dq:
                ans.append('0')
            else:
                ans.append('1')

    ans = '\n'.join(ans)

    return str(ans) if type(ans) != str else ans

def main():
    if DEBUG:
        print_data()
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