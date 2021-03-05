import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

def nextPerm(s):
    i = len(s)-2
    j = 0
    while i >= 0 and s[i] >= s[i+1]:
        i -= 1
    
    if i == -1:
        return s
    else:
        j = i+1
        while j < len(s) and s[j] > s[i]:
            j += 1
        s[i], s[j-1] = s[j-1], s[i]
        return s[:i+1] + s[:i:-1]

_, *S = map(lambda x:x.rstrip(), sys.stdin)
for v in S:
    print(''.join(nextPerm(list(v))))