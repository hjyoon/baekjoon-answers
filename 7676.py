import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

while True:
    R, N = map(int, input().rstrip().split())
    if R == N == -1:
        break
    S = sorted(map(int, input().rstrip().split()))
    
    i = 0
    ans = 0

    while i < N:
        s = S[i]

        while i < N and S[i] <= s + R:
            i += 1

        p = S[i-1]

        while i < N and S[i] <= p + R:
            i += 1

        ans += 1

    print(ans)