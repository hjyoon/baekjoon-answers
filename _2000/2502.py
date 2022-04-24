import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

fibo = [0, 1]
for i in range(2, 31):  # 10만 이하까지만 구한다
    fibo.append(fibo[i-2] + fibo[i-1])

D, K = map(int, input().split())

a = 1
while True:
    if (K-fibo[D-2]*a)%fibo[D-1] == 0:
        b = (K-fibo[D-2]*a)//fibo[D-1]
        break
    a += 1

print(a, b, sep='\n')