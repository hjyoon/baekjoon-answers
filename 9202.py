import sys
import re
import collections
import itertools
import bisect
DEBUG = 1

TC = [
    {'data': [5, ['ICPC', 'ACM', 'CONTEST', 'GCPC', 'PROGRAMM'], 3, [['ACMA', 'APCA', 'TOGI', 'NEST'], ['PCMM', 'RXAI', 'ORCN', 'GPCG'], ['ICPC', 'GCPC', 'ICPC', 'GCPC']]], 'AC': '8 CONTEST 4\n14 PROGRAMM 4\n2 GCPC 2'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    #N, S = map(lambda x:x.rstrip(), in_f)
    w = int(input().rstrip())
    S = {input().rstrip() for _ in range(w)}
    input()
    b = int(input().rstrip())
    B = []
    for _ in range(b):
        tmp = [input().rstrip() for _ in range(4)]
        input()
        B.append(tmp)

    data = [w, S, b, B]
    if DEBUG:
        #ac = out_f.readline().rstrip()
        ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(w, S:set, b, B):
    graph = {}
    visit = [[0]*4 for _ in range(4)]
    d = [(-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1)]
    for i in range(4):
        for j in range(4):
            for y, x in d:
                if i+y>=0 and j+x>=0 and i+y<4 and j+x<4:
                    graph.setdefault(f'{i}{j}', []).append(f'{i+y}{j+x}')

    def dfs(i, j, depth, txt):
        nonlocal ans, score, find_list, longest_s
        if visit[i][j] == 1:
            return
        if depth > 8:
            return

        if txt in S and txt not in find_list:
            ans += 1
            find_list.add(txt)
            if len(txt) <= 2:
                score += 0
            elif len(txt) <= 4:
                score += 1
            elif len(txt) <= 5:
                score += 2
            elif len(txt) <= 6:
                score += 3
            elif len(txt) <= 7:
                score += 5
            elif len(txt) <= 8:
                score += 11

            if longest_s == None:
                longest_s = txt
            else:
                if len(longest_s) < len(txt):
                    longest_s = txt
                elif len(longest_s) == len(txt):
                    if longest_s > txt:
                        longest_s = txt
        visit[i][j] = 1
        nonlocal board
        for v in graph[f'{i}{j}']:
            y, x = map(int, v)
            dfs(y, x, depth+1, txt + board[y][x])
        visit[i][j] = 0
    res = []
    for board in B:
        ans = 0
        score = 0
        longest_s = None
        find_list = set()
        for i in range(4):
            for j in range(4):
                dfs(i, j, 1, board[i][j])
        res.append(f'{score} {longest_s} {ans}')

    return '\n'.join(res)

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