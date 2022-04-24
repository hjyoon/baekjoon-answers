import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

*S, _ = map(lambda x:x.rstrip(), sys.stdin)
for v in S:
    a = set(map(lambda x:str.upper(x[0]), v.split()))
    print(f"{['N','Y'][len(a)==1]}")