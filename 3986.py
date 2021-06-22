import sys
import re
import collections
import itertools
import bisect
DEBUG = 1

TC = [
    {'data': [3, ['ABAB', 'AABB', 'ABBA']], 'AC': '2'},
    {'data': [3, ['AAA', 'AA', 'AB']], 'AC': '1'},
    {'data': [1, ['ABBABB']], 'AC': '1'}
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    #N, S = map(lambda x:x.rstrip(), in_f)
    N = int(input().rstrip())
    S = [input().rstrip() for _ in range(N)]

    data = [N, S]
    if DEBUG:
        ac = out_f.readline().rstrip()
        #ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def sol(s:str, st:list):
    for v in s:
        if not st:
            st.append(v)
        else:
            if st[-1] == v:
                st.pop()
            else:
                st.append(v)
    if st:
        return False
    else:
        return True

def solution(N, S):
    ans = 0
    for s in S:
        st = []
        if sol(s, st):
            ans += 1
        else:
            pass
    
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