import sys
sys.stdin = open("input.txt", 'r')

T = int(input())
for i in range(T):
    a = input()
    b = input()
    l = zip(a, b)
    l = list(filter(lambda x:x[0]!=x[1], l))
    print(f'Hamming distance is {len(l)}.')