import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

K, N = map(int, input().split())

S = sorted(map(lambda x:(int((x.rstrip()*10)[:10]), x.rstrip()), sys.stdin), reverse=True, key=lambda x:(x[0], len(x[1])))
if K >= N:
    print(S[0][1]*(N-K), end='')
    for a, b in S:
        print(b, end='')
else:
    SS = sorted(map(lambda x:int(x[1]), S), reverse=True)
    sw = True
    for a, b in S:
        if b == str(SS[0]) and sw == True:
            print(b*(N-K), end='')
            sw = False
        print(b, end='')