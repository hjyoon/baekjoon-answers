import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

T = int(input())
for i in range(1, T+1):
    n = int(input())
    s = input()
    print(f"Data Set {i}:\n{n + s.count('c') - s.count('b')}\n")