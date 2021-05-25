import sys
DEBUG = 1

A = 'N'
B = 'S'

TC = [
    {A:3,B:['Cat','fat','bAt'],'AC':'bAt'},
    {A:4,B:['call','ball','All','Hall'],'AC':'All'},
    {A:4,B:['BAc','CAb','BCa','CBa'],'AC':'BAc'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    while True:
        n = int(input().rstrip())
        if n == 0:
            break
        s = []
        for _ in range(n):
            s.append(input().rstrip())

        if DEBUG:
            ac = out_f.readline().rstrip()
            l.append({A:n, B:s, 'AC':ac})
        else:
            l.append({A:n, B:s})

def solution(n, s):
    ans = []
    s = sorted(map(lambda x:(x.lower(), x), s))
    ans.append(s[0][1])
    return '\n'.join(ans)

def main():
    if DEBUG:
        #print_data()
        #print(TC)
        pass
    else:
        TC.clear()
        read_data(TC, sys.stdin)

    for i, v in enumerate(TC, 1):
        res = solution(v[A], v[B])

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
    in_f = open("input.txt", 'r')
    out_f = open("output.txt", 'r')
    tmp = []
    read_data(tmp, in_f, out_f)
    print(tmp)

if __name__ == "__main__":
    main()