import sys
import re
import collections
import itertools
import math
DEBUG = 1

TC = [
    {'data': [4, [3, 0, 1, 2]], 'AC': '2'},
    {'data': [4, [3, 2, 1, 0]], 'AC': '1'},
    {'data': [4, [0, 1, 2, 3]], 'AC': '2'},
    {'data': [10, [7, 4, 8, 6, 1, 5, 2, 9, 3, 0]], 'AC': '4'},
    {'data': [1, [0]], 'AC': '1'},
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

def solution(N, S):
    ans = 1
    s = [0] * (N+1)
    for i in range(N):
        s[S[i]] = i
    s[N] = -1

    for i in range(N-1):
        if s[S[i]+1] > s[S[i+1]+1]:
            ans += 1

    return ans_to_str(ans)


def ans_to_str(ans):
    if type(ans) == list:
        return '\n'.join(map(str, ans))
    elif type(ans) != str:
        return str(ans)
    else:
        return ans

def main():
    if DEBUG:
        print_data()
        #print(TC)
        pass
    else:
        TC.clear()
        read_data(TC, sys.stdin)
        #read_data(TC, open('input.txt', 'r'))

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