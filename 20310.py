import sys
import re
import collections
import itertools
DEBUG = 1

TC = [
    {'data': ['1010'], 'AC': '01'},
    {'data': ['000011'], 'AC': '001'},
    {'data': ['00'], 'AC': '0'},
    {'data': ['11'], 'AC': '1'},
    {'data': ['1100'], 'AC': '10'},
    {'data': ['011000'], 'AC': '010'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    S = input().rstrip()

    data = [S]
    if DEBUG:
        ac = out_f.readline().rstrip()
        #ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(S):
    ans = []
    zero, one = 0, 0
    for s in S:
        if s == '0':
            zero += 1
        else:
            one += 1

    zero //= 2
    one //= 2
        
    for s in S:
        if s == '0':
            if zero > 0:
                zero -= 1
                ans.append(s)
            else:
                continue
        else:
            if one > 0:
                one -= 1
            else:
                ans.append(s)
                continue

    ans = ''.join(ans)

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