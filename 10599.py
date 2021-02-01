import sys
sys.stdin = open("input.txt", 'r')

N, *S = map(lambda x:x.rstrip(), sys.stdin)

for i in range(int(N)):
    if S[i] == '1 2 3 4 5 1 2 3 4 5':
        print(i+1)