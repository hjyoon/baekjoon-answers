import sys
sys.stdin = open('input.txt')
input = sys.stdin.readline

N = int(input())
S = [int(input()) for _ in range(N)]
print(sum(S)-(len(S)-1))
