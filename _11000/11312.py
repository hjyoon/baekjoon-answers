import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(lambda x:x.rstrip(), sys.stdin)

for v in S:
    A, B = map(int, v.split())
    print(A**2//B**2)