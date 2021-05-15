import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

*S, _ = map(lambda x:x.rstrip(), sys.stdin)

for v in S:
    ans = False
    for i in range(1, len(v)):
        d = {}
        for w in zip(v, v[i:]):
            tmp = ''.join(w)
            if tmp in d:
                ans = True
                break
            else:
                d[tmp] = True
        if ans:
            break

    print(f'{v} is{["", " NOT"][ans]} surprising.')