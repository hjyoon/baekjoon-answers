import sys
DEBUG = 1

TC = [
    {'data': ['1234567'], 'AC': '3\nNO'},
    {'data': ['129'], 'AC': '2\nYES'},
    {'data': ['123'], 'AC': '1\nYES'},
    {'data': ['1'], 'AC': '0\nNO'},
    {'data': ['6'], 'AC': '0\nYES'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    s = input().rstrip()

    data = [s]
    if DEBUG:
        ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(s):
    ans = 0
    while True:
        if len(s) == 1:
            if int(s) % 3 == 0:
                ans = f'{ans}\nYES'
            else:
                ans = f'{ans}\nNO'
            break
        else:
            s = sum(map(int, list(s)))
            s = str(s)
            ans += 1
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