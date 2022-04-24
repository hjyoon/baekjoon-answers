import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    ans = 0
    n = list(input().rstrip())
    while True:
        if n == list(str(6174)):
            break
        n.sort()
        a = int(''.join(n))
        b = int(''.join(n[::-1]))
        n = b-a
        n = list('0'*(4-len(str(n)))+str(n))
        ans += 1

    print(ans)
