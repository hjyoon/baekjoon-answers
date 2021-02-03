import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = input()
print(oct(int(N, 2))[2:])