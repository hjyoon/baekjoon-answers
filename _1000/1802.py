import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(lambda x:x.rstrip(), sys.stdin)

for v in S:
    chk = [0] * len(v)
    step = 2
    ans = 'YES'
    while True:
        i = 0
        for j in range(len(v)):
            if chk[j] == 0:
                i = j
                break
        first = True
        sw = None
        while True:
            if i >= len(v):
                break
            if first:
                chk[i] = 1
                sw = v[i]
                first = False
                i += step
            else:
                if sw != v[i]:
                    sw = v[i]
                    chk[i] = 1
                    i += step
                    continue
                else:
                    ans = 'NO'
                    break
        if ans == 'NO':
            break
        step *= 2
        if step >= len(v):
            break
    print(ans)