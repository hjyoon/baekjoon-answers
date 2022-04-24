import sys
import re
DEBUG = 1

TC = [
    {'data': [4, 'A B C D', 'D A B C', 'C B A P'], 'AC': 'B A P C'},
    {'data': [4, 'A B C D', 'A B C D', 'C B A P'], 'AC': 'C B A P'},
    {'data': [3, 'SECURITY THROUGH OBSCURITY', 'OBSCURITY THROUGH SECURITY', 'TOMORROW ATTACK WE'], 'AC': 'WE ATTACK TOMORROW'}
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    t = int(input().rstrip())
    for _ in range(t):
        n = int(input().rstrip())
        s1 = input().rstrip()
        s2 = input().rstrip()
        s3 = input().rstrip()

        data = [n, s1, s2, s3]
        if DEBUG:
            ac = out_f.readline().rstrip()
            #ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
            l.append({'data':data, 'AC':ac})
        else:
            l.append({'data':data})

def solution(n, s1, s2, s3):
    ans = [None] * n
    s1 = s1.split()
    s2 = s2.split()
    s3 = s3.split()
    tmp = []
    for i in range(n):
        tmp.append(s1.index(s2[i]))

    for i in range(n):
        ans[tmp[i]] = s3[i]
        
    return ' '.join(ans)

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