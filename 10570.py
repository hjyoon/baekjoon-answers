import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

import collections

T = int(input())
for i in range(T):
    V = int(input())
    S = []
    for j in range(V):
        S.append(int(input()))
    S.sort()
    S = collections.Counter(S)
    print(S.most_common(1)[0][0])