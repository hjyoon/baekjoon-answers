import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = map(lambda x:x.rstrip(), sys.stdin)

for _ in S:
    s, t = _.split()
    ans = None
    start = -1
    for a in s:
        start = t.find(a, start+1)
        if start == -1:
            ans = "No"
            break
    if start == -1:
        ans = "No"
    else:
        ans = "Yes"
    print(ans)