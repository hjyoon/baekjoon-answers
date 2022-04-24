import sys
sys.stdin = open("input.txt", 'r')

days = ['Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday', 'Monday', 'Tuesday']
D, M = map(int, input().split())
for i in range(1, M):
    if i in [1, 3, 5, 7, 8, 10, 12]:
        D += 31
    elif i in [4, 6, 9, 11]:
        D += 30
    else:
        D += 28
print(days[D % 7])