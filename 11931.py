import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_, *S = map(lambda x:x.rstrip(), sys.stdin)
S = sorted(map(int, S), reverse=True)
S = map(str, S)
sys.stdout.write('\n'.join(S))