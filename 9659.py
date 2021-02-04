import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

N = int(input())
print('SK' if N%2 == 1 else 'CY')