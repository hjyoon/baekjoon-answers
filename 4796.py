import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

*S, _ = map(lambda x:x.rstrip(), sys.stdin)
for i, v in enumerate(S, 1):
    L, P, V = map(int, v.split())
    print(f'Case {i}: {V//P*L + min(L, V%P)}')