import sys
DEBUG = 1

TC = [
    {'data': ['  start:  integer;    // begins here\nstop: integer; //  ends here  \n s:  string;   \nc:   char; // temp '], 'AC': 'start: integer; // begins here\nstop:  integer; // ends   here\ns:     string;\nc:     char;    // temp'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    s = ''.join(in_f)

    data = [s]
    if DEBUG:
        ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(s):
    ans = []
    s = map(lambda x:x.strip(), s.split('\n'))
    s = list(map(lambda x:x.split(), s))
    m = len(max(s, key=lambda x:len(x)))
    sz = [0] * m
    for i in range(m):
        for v in s:
            if i >= len(v):
                continue
            else:
                sz[i] = max(sz[i], len(v[i]))

    for v in s:
        tmp = []
        for i, w in enumerate(v):
            if i == len(v)-1:
                tmp.append(w)
            else:
                tmp.append(w + ((sz[i]-len(w)) * ' '))
        ans.append(tmp)
    ans = map(lambda x:' '.join(x), ans)
    ans = '\n'.join(ans)
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