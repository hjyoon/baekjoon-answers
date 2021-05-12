import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())
S = []
d = {}
for _ in range(N):
    S.append(input().rstrip())

SS = []

for v in S:
    t = v.split()
    ts = []
    chk = False
    for w in t:
        s = str.lower(w[0])
        if s not in d and chk == False:
            d[s] = True
            w = w.replace(w[0], f'[{w[0]}]', 1)
            chk = True
        ts.append(w)
    if chk == True:
        SS.append(' '.join(ts))

    ts = []
    end = False
    if chk == False:
        for s in v:
            if str.isalpha(s):
                t = str.lower(s)
                if t not in d and end == False:
                    d[t] = True
                    s = f'[{s}]'
                    end = True
            ts.append(s)
        SS.append(''.join(ts))

print(*SS, sep='\n')