import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

T, *S = map(lambda x:x.rstrip(), sys.stdin)

for i in S:
    D, N, S, P = map(int, i.split())
    if N*P+D < N*S:
        print('parallelize')
    elif N*P+D > N*S:
        print('do not parallelize')
    else:
        print('does not matter')