import sys
import re
import collections
import itertools
import bisect
DEBUG = 1

TC = [
    {'data': [4, [1, 2, 3, 4]], 'AC': '12'},
    {'data': [5, [100, 2, 1, 3, 100]], 'AC': '10400'},
    {'data': [7, [2, 2, 7, 6, 90, 5, 9]], 'AC': '1818'},
    {'data': [10, [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]], 'AC': '8'},
    {'data': [5, [3, 1, 2, 4, 5]], 'AC': '33'}
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    #N, S = map(lambda x:x.rstrip(), in_f)
    N = int(input().rstrip())
    S = list(map(int, input().rstrip().split()))

    data = [N, S]
    if DEBUG:
        #ac = out_f.readline().rstrip()
        ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(N, S:list):
    ans = 0

    def dfs(s:list, v):
        nonlocal ans
        if len(s) == 2:
            ans = max(ans, v)
            return
        for i in range(1, len(s)-1):
            dfs(s[:i] + s[i+1:], v+(s[i-1]*s[i+1]))
    
    dfs(S[::], 0)

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