import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = list(map(int, input().rstrip().split()))
ans = 0

def dfs(pos, pick, times, cnt):
    global ans
    if times == 3:
        #print('times out')
        return
    if N[pos] == pick:
        cnt += 1
    #print(pos, pick, times, cnt)
    if pos == len(N)-1:
        #print('end')
        if cnt >= 5:
            ans += 1
        #ans = max(ans, cnt)
        return
    for i in range(1, 6):
        if i == pick:
            dfs(pos+1, i, times+1, cnt)
        else:
            dfs(pos+1, i, 1, cnt)

for i in range(1, 6):
    dfs(0, i, 1, 0)

print(ans)