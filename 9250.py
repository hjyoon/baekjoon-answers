import sys
import re
import collections
import itertools
import math
DEBUG = 1

TC = [
    {'data': [3, ['www', 'woo', 'jun'], 3, ['myungwoo', 'hongjun', 'dooho']], 'AC': 'YES\nYES\nNO'},
    {'data': [4, ['aaaa', 'aa', 'aaabc', 'baaacd'], 1, ['baaab']], 'AC': 'YES'},
    {'data': [1, ['abc'], 1, ['aabc']], 'AC': 'YES'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    #N, S = map(lambda x:x.rstrip(), in_f)
    N = int(input().rstrip())
    L = [input().rstrip() for _ in range(N)]
    Q = int(input().rstrip())
    M = [input().rstrip() for _ in range(Q)]
    data = [N, L, Q, M]
    if DEBUG:
        #ac = out_f.readline().rstrip()
        ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(N, L, Q, M):
    L = set(L)
    ans = []
    graph = {}
    for s in L:
        tmp = ''
        for c in s:
            tmp += c
            if tmp not in graph:
                graph[tmp] = {'valid':False, 'pi':None, 'indexes':None}
        graph[tmp]['valid'] = True
        
    for k in graph.keys():
        for i in range(1, len(k)):
            t = k[i:]
            if t in graph:
                graph[k]['pi'] = t
                break
    
    for k in graph.keys():
        s = set()
        pi = k
        while True:
            if pi == None:
                break
            else:
                s.add(pi)
                pi = graph[pi]['pi']
        graph[k]['indexes'] = s

    for S in M:
        if chk(graph, S, L):
            ans.append('YES')
        else:
            ans.append('NO')

    return ans_to_str(ans)

def chk(graph, S, L:set):
    pre = None
    tmp = None
    i = 0
    while i < len(S):
        pre = tmp
        if tmp == None:
            tmp = S[i]
        else:
            tmp += S[i]

        if tmp in graph:
            pi = tmp
            if not L.isdisjoint(graph[pi]['indexes']):
                return True
            i += 1
        else:
            if pre in graph:
                tmp = graph[pre]['pi']
                if tmp == None:
                    pass
                else:
                    pass
            else:
                tmp = None
                i += 1
                pass
    return False


def ans_to_str(ans):
    if type(ans) == list:
        return '\n'.join(ans)
    elif type(ans) != str:
        return str(ans)
    else:
        return ans

def main():
    if DEBUG:
        #print_data()
        #print(TC)
        pass
    else:
        TC.clear()
        #read_data(TC, sys.stdin)
        read_data(TC, open('input.txt', 'r'))

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