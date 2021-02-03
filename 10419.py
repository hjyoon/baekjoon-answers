import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

T, *S = map(int, sys.stdin)
for i in S:
    if i == 1:
        print(0)
        continue
    for j in range(1, 100):
        if j*(j+1) <= i and i < (j+1)*(j+2): 
            print(j)
            break