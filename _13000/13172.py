import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

def extended_gcd(a, b):
    x,y, u,v = 0,1, 1,0
    while a != 0:
        q, r = b//a, b%a
        m, n = x-u*q, y-v*q
        b,a, x,y, u,v = a,r, u,v, m,n
    gcd = b
    return gcd, x, y

def fast_pow(x, y):
    if y == 0:
        return 1

    # 계산을 한 번만 하기 위해서 변수에 저장
    semi_result = fast_pow(x, y // 2)
    
    # 문제를 최대한 똑같은 크기의 문제 두 개로 나눠준다 (짝수, 홀수 경우 따로)
    if y % 2 == 0:
        return (semi_result * semi_result) % 1000000007
    else:
        return (x * semi_result * semi_result) % 1000000007

M = int(input().rstrip())
r = 0
for i in range(M):
    N, S = map(int, input().rstrip().split())
    #N = extended_gcd(N, 1000000007)[1]
    N = fast_pow(N, 1000000007-2)
    r += (S * N) % 1000000007
print(r % 1000000007)