import sys
sys.stdin = open("input.txt", 'r')

n = int(input())

i = 1
sum = 0
while sum<n:
    sum += i
    if sum>n:
        break;
    else:
        i += 1;

print(i-1)