import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

T, *S = map(lambda x:x.rstrip(), sys.stdin)
T = int(T)
for i in range(T):
    N, M = map(int, S[i].split())
    s = ((M-N+1)*(N+M))//2
    print(f'Scenario #{i+1}:\n{s}\n')