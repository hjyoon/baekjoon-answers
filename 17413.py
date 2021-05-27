import sys
import re
DEBUG = 1

TC = [
    {'data': ['baekjoon online judge'], 'AC': 'noojkeab enilno egduj'},
    {'data': ['<open>tag<close>'], 'AC': '<open>gat<close>'},
    {'data': ['<ab cd>ef gh<ij kl>'], 'AC': '<ab cd>fe hg<ij kl>'},
    {'data': ['one1 two2 three3 4fourr 5five 6six'], 'AC': '1eno 2owt 3eerht rruof4 evif5 xis6'},
    {'data': ['<int><max>2147483647<long long><max>9223372036854775807'], 'AC': '<int><max>7463847412<long long><max>7085774586302733229'},
    {'data': ['<problem>17413<is hardest>problem ever<end>'], 'AC': '<problem>31471<is hardest>melborp reve<end>'},
    {'data': ['<   space   >space space space<    spa   c e>'], 'AC': '<   space   >ecaps ecaps ecaps<    spa   c e>'},

]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    s = input()

    data = [s]
    if DEBUG:
        ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(s:str):
    ans = str()
    tmp = re.findall('<[a-z ]+?>|\\b[a-z0-9]+?\\b', s)
    for v in tmp:
        if v[0] == '<':
            ans = ans.rstrip() + v
        else:
            ans += f'{v[::-1]} '
    return ans.rstrip()

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