import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

T, *N = map(int, sys.stdin)
print(list(N))

if N[1]-N[0] == N[2]-N[1]:
    print(N[-1]+(N[1]-N[0]))
else:
    print(N[-1]*(N[1]//N[0]))