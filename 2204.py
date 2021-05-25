import sys
input = sys.stdin.readline
DEBUG = 1

TC = [
    {'N': 3, 'S': ['Cat', 'fat', 'bAt'],'AC':'bAt'},
    {'N': 4, 'S': ['call', 'ball', 'All', 'Hall'],'AC':'All'},
    {'N': 4, 'S': ['BAc', 'CAb', 'BCa', 'CBa'],'AC':'BAc'},
]

def copy_data():
    global input
    sys.stdin = open("input.txt", 'r')
    input = sys.stdin.readline
    tmp = []
    read_data(tmp)
    print(tmp)

def read_data(l):
    l = list(l)
    while True:
        N = int(input())
        if N == 0:
            break
        S = []
        for _ in range(N):
            S.append(input().rstrip())
        l.append({'N':N, 'S':S})

if DEBUG:
    #copy_data()
    #print(TC)
    pass
else:
    TC.clear()
    read_data(TC)

def solution(N, S):
    ans = []
    S = sorted(map(lambda x:(x.lower(), x), S))
    ans.append(S[0][1])
    return '\n'.join(ans)

def main():
    for i, v in enumerate(TC, 1):
        res = solution(v['N'], v['S'])

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

main()