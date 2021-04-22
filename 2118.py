import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline


N = int(input().rstrip())
S = []
for i in range(N):
    t = int(input().rstrip())
    if i > 0:
        S.append(S[i-1] + t)
    else:
        S.append(t)

ans = float('-inf')

def solve(i):
    global ans
    left = i
    right = N-1
    mid = 0

    def chk():
        global ans
        a = None
        b = None
        if i > 0:
            a = S[-1] - (S[mid] - S[i-1])
            b = S[mid] - S[i-1]
        else:
            a = S[-1] - S[mid]
            b = S[mid]
        ans = max(ans, min(a, b))
        if a > b:
            return False
        else:
            return True
    
    while left <= right:
        mid = (left + right) // 2
        if chk():
            right = mid - 1
        else:
            left = mid + 1

for i in range(len(S)):
    solve(i)

print(ans)