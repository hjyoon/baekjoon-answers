import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline


T = int(input().rstrip())
for i in range(T):
    N, M = map(int, input().rstrip().split())
    l = []
    c = [0] * N
    r = 0
    for j in range(M):
        a, b = map(int, input().rstrip().split())
        l.append((a, b))
    l.sort(key=lambda x:(x[1]))

    for v in l:
        a, b = v
        for j in range(a-1, b):
            if c[j] == 1:
                continue
            c[j] = 1
            r += 1
            break

    print(r)