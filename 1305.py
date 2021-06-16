import sys
import re
import collections
import itertools
DEBUG = 1

TC = [
    {'data': ['5', 'aaaaa'], 'AC': '1'},
    {'data': ['3', 'aba'], 'AC': '2'},
    {'data': ['4', 'abab'], 'AC': '2'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    N, S = map(lambda x:x.rstrip(), in_f)

    data = [N, S]
    if DEBUG:
        ac = out_f.readline().rstrip()
        #ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def computeLPS(pat, lps):
    leng = 0

    i = 1
    while i < len(pat):
        if pat[i] == pat[leng]:
            leng += 1
            lps[i] = leng
            i += 1
        else:
            if leng != 0:
                leng = lps[leng-1]
            else:
                lps[i] = 0
                i += 1

def solution(N, S):
    ans = None
    lps = [0] * len(S)
    computeLPS(S, lps)
    ans = len(S) - lps[len(S)-1]
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