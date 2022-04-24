import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

#vowel = 'AEIOU'
#consonant = 'BCDFGHJKLMNPQRSTVWXYZ'
#all_alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
can = ('ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'AEIOU', 'BCDFGHJKLMNPQRSTVWXYZ', 'L', '')
#can = ('AL', 'AAAAA', 'BBBBBBBBBBBBBBBBBBBBL', 'L', '')


def candidates(i):
    ret = 0
    l = (
        (S[i+1], S[i+2]),
        (S[i-1], S[i+1]),
        (S[i-2], S[i-1])
    )

    for a, b in l:
        if a in 'BCDFGHJKLMNPQRSTVWXYZ' and b in 'BCDFGHJKLMNPQRSTVWXYZ':
            ret = 1
            break
        elif a in 'AEIOU' and b in 'AEIOU':
            ret = 2
            break
        else:
            pass

    if ret == 0 or ret == 2:
        if i == under_list[-1] and L_cnt == 0:
            ret = 3
    else:
        if i == under_list[-1] and L_cnt == 0:
            ret = 4

    return ret  # 3:모두가능, 2:자음가능, 1:모음가능, 0: L만가능


def dfs(cnt, fr):
    global ans
    global L_cnt
    if cnt == 0:
        # if L_cnt:
        ans += 1
        print(S)
        return
    # print(fr)
    i = under_list[fr]
    candidate = can[candidates(i)]
    for c in candidate:
        S[i] = c
        if c == 'L':
            L_cnt += 1
        dfs(cnt-1, fr+1)
        S[i] = '_'
        if c == 'L':
            L_cnt -= 1


S = list('  ' + input().rstrip() + '  ')
L_cnt = S.count('L')
ans = 0
# print(S)

under_list = []
for i in range(len(S)):
    if S[i] == '_':
        under_list.append(i)

dfs(len(under_list), 0)
print(ans)
