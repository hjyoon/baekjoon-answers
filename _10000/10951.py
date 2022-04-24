import sys
sys.stdin = open("input.txt", 'r')

for L in sys.stdin:
    print(sum(map(int, L.split())))