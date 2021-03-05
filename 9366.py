import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(lambda x:x.rstrip(), sys.stdin)
for i, v in enumerate(S):
    a, b, c = sorted(map(int, v.split()))
    if a+b <= c:
        print(f'Case #{i+1}: invalid!')
        continue

    if a==b and a==c:
        print(f'Case #{i+1}: equilateral')
    elif a==b or b==c:
        print(f'Case #{i+1}: isosceles')
    else:
        print(f'Case #{i+1}: scalene')
