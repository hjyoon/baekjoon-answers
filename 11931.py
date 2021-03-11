import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(lambda x:x.rstrip(), sys.stdin)
S = sorted(map(int, S), reverse=True)
list(map(print, S))
print(*S, end='\n')