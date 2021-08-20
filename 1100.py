import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

S = list(map(lambda x: x.rstrip(), sys.stdin))

ans = 0
for i in range(8):
    for j in range(8):
        if (i+j) % 2 == 0 and S[i][j] == 'F':
            ans += 1
print(ans)
