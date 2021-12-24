import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

C, P = map(int, input().split())
S = list(map(int, input().split()))
ans = 0

if P == 1:
    # case 1
    ans += C
    
    # case 2
    for i in range(len(S)-4+1):
        if S[i] == S[i+1] == S[i+2] == S[i+3]:
            ans += 1
elif P == 2:
    # case 1
    for i in range(len(S)-2+1):
        if S[i] == S[i+1]:
            ans += 1
elif P == 3:
    # case 1
    for i in range(len(S)-3+1):
        if S[i] == S[i+1] and S[i+1]+1 == S[i+2]:
            ans += 1
            
    # case 2
    for i in range(len(S)-2+1):
        if S[i] == S[i+1]+1:
            ans += 1
elif P == 4:
    # case 1
    for i in range(len(S)-3+1):
        if S[i] == S[i+1]+1 and S[i+1] == S[i+2]:
            ans += 1
            
    # case 2
    for i in range(len(S)-2+1):
        if S[i]+1 == S[i+1]:
            ans += 1
elif P == 5:
    # case 1
    for i in range(len(S)-3+1):
        if S[i] == S[i+1] == S[i+2]:
            ans += 1
            
    # case 2
    for i in range(len(S)-2+1):
        if S[i]+1 == S[i+1]:
            ans += 1
            
    # case 3
    for i in range(len(S)-2+1):
        if S[i] == S[i+1]+1:
            ans += 1
            
    # case 4
    for i in range(len(S)-3+1):
        if S[i] == S[i+1]+1 and S[i+2] == S[i+1]+1:
            ans += 1
elif P == 6:
    # case 1
    for i in range(len(S)-3+1):
        if S[i] == S[i+1] == S[i+2]:
            ans += 1
            
    # case 2
    for i in range(len(S)-2+1):
        if S[i] == S[i+1]:
            ans += 1
            
    # case 3
    for i in range(len(S)-2+1):
        if S[i] == S[i+1]+2:
            ans += 1
            
    # case 4
    for i in range(len(S)-3+1):
        if S[i]+1 == S[i+1] and S[i+1] == S[i+2]:
            ans += 1
elif P == 7:
    # case 1
    for i in range(len(S)-3+1):
        if S[i] == S[i+1] == S[i+2]:
            ans += 1
            
    # case 2
    for i in range(len(S)-2+1):
        if S[i] == S[i+1]:
            ans += 1
            
    # case 3
    for i in range(len(S)-2+1):
        if S[i]+2 == S[i+1]:
            ans += 1
            
    # case 4
    for i in range(len(S)-3+1):
        if S[i+2]+1 == S[i+1] and S[i+1] == S[i]:
            ans += 1
    
print(ans)