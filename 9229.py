import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = map(lambda x:x.rstrip(), sys.stdin)
l = []
t = []
for s in S:
    if s == '#' and len(t) > 0:
        l.append(t.copy())
        t.clear()
    else:
        t.append(s)

for s in l:
    chk = False
    for a, b in zip(s, s[1:]):
        dif_cnt = 0
        if chk:
            break
        if len(a) != len(b):
            chk = True
            break

        for c, d in zip(a, b):
            #print(c, d)
            if c == d:
                continue
            else:
                if dif_cnt == 0:
                    dif_cnt = 1
                else:
                    chk = True
                    break
        
        if dif_cnt != 1:
            chk = True
            break

    if chk:
        print('Incorrect')
    else:
        print('Correct')