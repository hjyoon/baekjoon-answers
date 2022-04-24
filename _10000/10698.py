import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(lambda x:x.rstrip(), sys.stdin)
for i, v in enumerate(S):
    ex, ans = v.split(' = ')
    print(f'Case {i+1}: {["NO", "YES"][eval(ex) == int(ans)]}')