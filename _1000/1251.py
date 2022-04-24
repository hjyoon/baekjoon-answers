import sys
import itertools
DEBUG = 1

TC = [
    {'data':['mobitel'],'AC':'bometil'}
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    s = input().rstrip()

    data = [s]
    if DEBUG:
        ac = out_f.readline().rstrip()
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(s):
    ans = []
    for a, b in itertools.combinations(range(len(s)-1),2):
        ans.append(s[:a+1][::-1] + s[a+1:b+1][::-1] + s[b+1:][::-1])
    ans.sort()
    return ans[0]

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
    in_f = open("input.txt", 'r')
    out_f = open("output.txt", 'r')
    tmp = []
    read_data(tmp, in_f, out_f)
    print(tmp)

if __name__ == "__main__":
    main()