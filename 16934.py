import sys
import re
import collections
import itertools
import math
DEBUG = 1

TC = [
    {'data': [5, ['baekjoon', 'startlink', 'bakejoon', 'beakjoon', 'baekjoon']], 'AC': 'b\ns\nbak\nbe\nbaekjoon2'},
    {'data': [7, ['codeplus', 'startlink', 'beakjoon', 'baek', 'baekjoon', 'baek', 'codingwiki']], 'AC': 'c\ns\nb\nba\nbaekj\nbaek2\ncodi'},
    {'data': [6, ['abcd', 'ab', 'ab', 'a', 'a', 'ab']], 'AC': 'a\nab\nab2\na\na2\nab3'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    #N, S = map(lambda x:x.rstrip(), in_f)
    N = int(input().rstrip())
    L = [input().rstrip() for _ in range(N)]

    data = [N, L]
    if DEBUG:
        #ac = out_f.readline().rstrip()
        ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(N, L):
    ans = []
    graph = {}
    cnt_graph = {}

    for v in L:
        tmp = ''
        for c in v:
            tmp += c
            if tmp not in graph:
                graph[tmp] = False
            else:
                pass
        graph[tmp] = True

        sw = False
        tmp = ''
        for c in v:
            tmp += c
            if graph[tmp]:
                continue
            else:
                graph[tmp] = True
                if not sw:
                    ans.append(tmp)
                    sw = True
                else:
                    pass
        if not sw:
            if tmp in cnt_graph:
                cnt_graph[tmp] += 1
                ans.append(f'{tmp}{cnt_graph[tmp]}')
            else:
                cnt_graph[tmp] = 1
                ans.append(f'{tmp}')
        else:
            if v in cnt_graph:
                pass
            else:
                cnt_graph[v] = 1

    return ans_to_str(ans)

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