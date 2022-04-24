import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())
S = []
d = {}
for _ in range(N):
    S.append(input().rstrip())

ans = []

for v in S:
    ts = []
    sw = False
    for w in v.split():
        ch = str.lower(w[0])
        if ch not in d and sw == False:
            d[ch] = True
            w = w.replace(w[0], f'[{w[0]}]', 1)
            sw = True
        ts.append(w)

    if sw == True:
        ans.append(' '.join(ts))
    else:
        ts.clear()
        for ch in v:
            if str.isalpha(ch):
                t = str.lower(ch)
                if t not in d and sw == False:
                    d[t] = True
                    ch = f'[{ch}]'
                    sw = True
            ts.append(ch)
        ans.append(''.join(ts))

print(*ans, sep='\n')