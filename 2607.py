import sys
from string import ascii_uppercase
input = sys.stdin.readline

N = int(input())
S = [input().rstrip() for _ in range(N)]

first_word = {v:0 for v in ascii_uppercase}
for s in S[0]:
    first_word[s] += 1
    
ans = 0
for i in range(1, len(S)):
    d = {v:0 for v in ascii_uppercase}
    for s in S[i]:
        d[s] += 1
    
    # 1개 차이나는 개수
    over = 0
    under = 0
    
    # 같은 구성
    for s in ascii_uppercase:
        if first_word[s]-d[s] == 1:
            over += 1
        elif d[s]-first_word[s] == 1:
            under += 1
        elif abs(first_word[s]-d[s]) > 1:
            break
        if over > 1 or under > 1:
            break
    else:
        ans += 1
        #print(S[i])
        
print(ans)