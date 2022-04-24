import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

*S, _ = map(lambda x:x.rstrip(), sys.stdin)

for i in S:
    a, b = sorted(map(int, i.split()))
    print(3*a-(a+b))