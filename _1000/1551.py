import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N, S = map(lambda x:x.rstrip(), sys.stdin)
N, K = map(int, N.split())
S = tuple(map(int, S.split(',')))
for i in range(K):
    tmp = [S[i+1] - S[i] for i in range(len(S)-1)]
    S = tuple(tmp)
print(*S, sep=',')