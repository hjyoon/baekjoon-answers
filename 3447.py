import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = map(lambda x:x.rstrip(), sys.stdin)
ans = []
for s in S:
    t = len(s)
    while True:
        s = s.replace('BUG', '')
        if t == len(s):
            ans.append(s)
            break
        t = len(s)
print(*ans, sep='\n')