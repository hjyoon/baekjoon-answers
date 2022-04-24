import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())

print(f'{int(N*0.78)} {int(N-N*0.2*0.22)}')