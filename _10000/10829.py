import sys
sys.stdin = open("input.txt", 'r')

print(bin(int(input()))[2:])