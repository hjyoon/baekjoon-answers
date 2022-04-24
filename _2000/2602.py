import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

def step_A(start, target_idx):
    if target_idx == len(S):
        return 1

    ret = 0
    for i in range(start, len(A)):
        if A[i] == S[target_idx]:
            tmp = step_B(i+1, target_idx+1)
            dp[i][target_idx][0] = tmp
            ret += tmp
    return ret

def step_B(start, target_idx):
    if target_idx == len(S):
        return 1

    ret = 0
    for i in range(start, len(B)):
        if B[i] == S[target_idx]:
            tmp = step_A(i+1, target_idx+1)
            dp[i][target_idx][1] = tmp
            ret += tmp
    return ret

S = input().rstrip()
A = input().rstrip()
B = input().rstrip()
ans = 0
dp = [[[0]*2 for _ in range(len(S))] for _ in range(len(A))]
ans += step_A(0, 0)
ans += step_B(0, 0)

print(dp)
print(ans)