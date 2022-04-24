import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import itertools

def chk(N, K):
    l = [0]*(N+1)
    c = 0
    for i in range(2, N+1):
        for t in itertools.count(1):
            if i*t <= N:
                if l[i*t] == 0:
                    l[i*t] = 1
                    c += 1
                    if c == K:
                        return i*t
            else:
                break

N, K = map(int, input().split())
print(chk(N, K))