import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

def chk(s):
    l = len(s)
    for i in range(l):
        for j in range(i+1, l):
            if (s[i]+s[j]) == (s[i]+s[j])[::-1]:
                return s[i]+s[j]
            elif (s[j]+s[i]) == (s[j]+s[i])[::-1]:
                return (s[j]+s[i])
    return 0

T = int(input())
for i in range(T):
    k = int(input())
    s = []
    for j in range(k):
        s.append(input().rstrip())
    print(chk(s))