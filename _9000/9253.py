import sys
import re
import collections
import itertools
DEBUG = 1

TC = [
    {'data': ['yeshowmuchiloveyoumydearmotherreallyicannotbelieveit', 'yeaphowmuchiloveyoumydearmother', 'howmuchiloveyoumydearmother'], 'AC': 'YES'},
    {'data': ['yeshowmuchiloveyoumydearmotherreallyicannotbelieveit', 'yeaphowmuchiloveyoumydearmother', 'iowmuchiloveyoumydearmother'], 'AC': 'NO'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    A = input().rstrip()
    B = input().rstrip()
    C = input().rstrip()

    data = [A, B, C]
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

def KMPSearch(pat, txt):
    M = len(pat)
    N = len(txt)

    lps = [0]*M
    computeLPS(pat, lps)

    i = 0
    j = 0
    while i < N:
        if pat[j] == txt[i]:
            i += 1
            j += 1
        elif pat[j] != txt[i]:
            if j != 0:
                j = lps[j-1]
            else:
                i += 1

        if j == M:
            return True
    return False

def solution(A, B, C):
    ans = ['NO', 'YES'][KMPSearch(C, A) and KMPSearch(C, B)]
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