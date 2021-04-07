import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(int, sys.stdin)

S = sorted(S)

r = 0
for i in range(len(S)):
    r = max(r, (len(S)-i) * S[i])
print(r)