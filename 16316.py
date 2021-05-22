import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())
S = input().rstrip().split()

cnt = 0

for v in S:
    if v == 'mumble':
        cnt += 1
        continue
    else:
        if int(v) == cnt + 1:
            cnt += 1
            continue
        else:
            print('something is fishy')
            break
else:
    print('makes sense')