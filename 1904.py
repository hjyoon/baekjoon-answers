import sys
import re
import itertools
DEBUG = 1

TC = [
    {'data': [1], 'AC': '1'},
    {'data': [2], 'AC': '2'},
    {'data': [3], 'AC': '3'},
    {'data': [4], 'AC': '5'},
    {'data': [5], 'AC': '8'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    N = int(input().rstrip())

    data = [N]
    if DEBUG:
        #ac = out_f.readline().rstrip()
        ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(N):
    ans = None
    dp = [1, 2] + [0] * 1000000
    for i in range(2, 1000000):
        dp[i] = (dp[i-1] + dp[i-2]) % 15746
    ans = dp[N-1]
    
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