import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

m = [1, 2, 3, 3, 4, 10]
n = [1, 2, 2, 2, 3, 5, 10]

T = int(input())
for i in range(T):
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    t1 = 0
    t2 = 0
    for j in range(6):
        t1 += m[j]*A[j]
    for j in range(7):
        t2 += n[j]*B[j]
    print(f'Battle {i+1}: ', end='')
    if t1 > t2:
        print('Good triumphs over Evil')
    elif t1 < t2:
        print('Evil eradicates all trace of Good')
    else:
        print('No victor on this battle field')