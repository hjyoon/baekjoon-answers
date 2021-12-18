import sys
input = sys.stdin.readline

al = 'abcdefghijklmnopqrstuvwxyz'
S = list(input().rstrip())
d = {}

for i in range(len(S)):
    d.setdefault(S[i], [])
    d[S[i]].append(i)
    
for s in al:
    if s in d:
        d[s].sort()
    
def cal(S, s, cur_pos, fir, sec):
    enter = 0
    dir_key = 0
    while True:
        if S[cur_pos] == s:
            enter += 1
        if cur_pos < fir:
            cur_pos += 1
            dir_key += 1
        elif cur_pos > fir:
            cur_pos -= 1
            dir_key += 1
        else:
            break
    if sec and fir != sec:
        while True:
            if S[cur_pos] == s:
                enter += 1
            if cur_pos < sec:
                cur_pos += 1
                dir_key += 1
            elif cur_pos > sec:
                cur_pos -= 1
                dir_key += 1
            else:
                break
    return (cur_pos, enter+dir_key)
    
def dfs(S, d, idx, cur_pos, ac):
    global ans
    if ac >= ans:
        return
    if idx >= len(al):
        ans = ac
        return
    s = al[idx]
    if s not in d:
        dfs(S, d, idx+1, cur_pos, ac)
        return
    print(s, cur_pos, ac)
    tmp_pos = cur_pos
    fir, sec = None, None
    if tmp_pos <= d[s][0]:
        fir = d[s][-1]
        tmp_pos, val = cal(S, s, cur_pos, fir, sec)
        dfs(S, d, idx+1, tmp_pos, ac+val)
    elif tmp_pos >= d[s][-1]:
        fir = d[s][0]
        tmp_pos, val = cal(S, s, cur_pos, fir, sec)
        dfs(S, d, idx+1, tmp_pos, ac+val)
    else:
        fir, sec = d[s][0], d[s][-1]
        tmp_pos, val = cal(S, s, cur_pos, fir, sec)
        dfs(S, d, idx+1, tmp_pos, ac+val)
        
        fir, sec = d[s][-1], d[s][0]
        tmp_pos, val = cal(S, s, cur_pos, fir, sec)
        dfs(S, d, idx+1, tmp_pos, ac+val)
        
ans = float('inf')
dfs(S, d, 0, 0, 0)
print(ans)