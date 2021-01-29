import sys
sys.stdin = open("input.txt", 'r')

X = map(lambda x: x.rstrip(), sys.stdin)

for i, v in enumerate(X):
    a, op, b = v.split()
    if op == 'E': break;
    print(f'Case {i+1}: {str(eval(f"{a}{op}{b}")).lower()}')