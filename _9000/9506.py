import sys
sys.stdin = open("input.txt", 'r')

while True:
    n = int(input())
    if n == -1:
        break;

    num = list(filter(lambda x:n%x==0, range(1, n//2+1)))
    if sum(num) == n:
        print(f'{n} = ', end='')
        for i, v in enumerate(num):
            if i == len(num)-1:
                print(f'{v}')
            else:
                print(f'{v} + ', end='')
    else:
        print(f'{n} is NOT perfect.')