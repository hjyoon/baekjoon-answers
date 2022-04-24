import sys
import re
DEBUG = 1

TC = [
    {'data': ['fotball'], 'AC': '1'},
    {'data': ['sopp'], 'AC': '2'},
    {'data': ['ingenting'], 'AC': '3'},
    {'data': ['spillolje'], 'AC': '0'},
    {'data': ['l'], 'AC': '2'},
    {'data': ['ll'], 'AC': '1'},
    {'data': ['o'], 'AC': '2'},
    {'data': ['ol'], 'AC': '1'},
    {'data': ['lo'], 'AC': '1'},
    {'data': ['olo'], 'AC': '1'},
    {'data': ['ollolool'], 'AC': '0'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    t = int(input().rstrip())
    for _ in range(t):
        s = input().rstrip()

        data = [s]
        if DEBUG:
            ac = out_f.readline().rstrip()
            #ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
            l.append({'data':data, 'AC':ac})
        else:
            l.append({'data':data})

def solution(s):
    ans = None

    if re.search('lol', s):
        ans = 0
    elif re.search('l.?l', s):
        ans = 1
    elif re.search('lo', s):
        ans = 1
    elif re.search('ol', s):
        ans = 1
    elif re.search('l', s):
        ans = 2
    elif re.search('o', s):
        ans = 2
    else:
        ans = 3
    
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
            res = solution(*v['data'])
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