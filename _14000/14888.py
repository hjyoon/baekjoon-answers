import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())
S = list(map(int, input().rstrip().split()))
O = list(map(int, input().rstrip().split()))

ans_max = float('-inf')
ans_min = float('inf')

def dfs(i, s):
    global ans_max, ans_min
    if i == N:
        ans_max = max(ans_max, s)
        ans_min = min(ans_min, s)
        return
    for j in range(4):
        if O[j] == 0:
            continue
        O[j] -= 1
        if j == 0:
            dfs(i+1, s+S[i])
        elif j == 1:
            dfs(i+1, s-S[i])
        elif j == 2:
            dfs(i+1, s*S[i])
        else:
            if s < 0:
                tmp = -s // S[i]
                tmp = -tmp
            else:
                tmp = s // S[i]
            dfs(i+1, tmp)
        O[j] += 1

dfs(1, S[0])
print(ans_max)
print(ans_min)