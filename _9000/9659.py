import sys
sys.stdin = open('input.txt', 'r')
input = sys.stdin.readline

print('SK' if int(input())%2 == 1 else 'CY')