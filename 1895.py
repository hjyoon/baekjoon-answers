import sys
import re
import itertools
DEBUG = 1

TC = [
    {'data': [6, 5, [[49, 36, 73, 62, 21], [27, 88, 14, 11, 12], [99, 18, 36, 91, 21], [45, 96, 72, 12, 10], [12, 48, 49, 75, 56], [12, 15, 48, 86, 78]], 40], 'AC': '7'},
    {'data': [3, 3, [[49, 36, 73], [14, 11, 12], [99, 18, 36]], 40], 'AC': '0'},
    {'data': [3, 3, [[0, 0, 0], [0, 0, 0], [0, 0, 0]], 0], 'AC': '1'},
]

def read_data(l, in_f, out_f=None):
    input = in_f.readline
    R, C = map(int, input().rstrip().split())
    a = []
    for _ in range(R):
        a.append(list(map(int, input().rstrip().split())))
    T = int(input().rstrip())

    data = [R, C, a, T]
    if DEBUG:
        #ac = out_f.readline().rstrip()
        ac = '\n'.join(map(lambda x:x.rstrip(), out_f))
        l.append({'data':data, 'AC':ac})
    else:
        l.append({'data':data})

def solution(R, C, a, T):
    ans = 0

    height, width = len(a), len(a[0]) # 2차원 배열의 전체 높이와 넓이
    part_h, part_w = 3, 3 # 뽑아낼 구역의 높이와 넓이
    tmp = []
    for i in range(height-part_h+1):
        tmp2 = []
        for j in range(width-part_w+1):
            tmp3 = []
            for row in a[i:i+part_h]:
                tmp3.extend(row[j:j+part_w])
            tmp3.sort()
            tmp2.append(tmp3[4])
        tmp.append(tmp2)

    for v in itertools.chain(*tmp):
        if v >= T:
            ans += 1
 
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