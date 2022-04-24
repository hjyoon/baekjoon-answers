import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

A, B, C = map(int, input().split())

m = [0] * 100

for _ in range(3):
    s, d = map(int, input().split())
    for i in range(s, d):
        m[i] += 1

def f(x):
    if x == 1:
        return A
    elif x == 2:
        return B*2
    elif x == 3:
        return C*3
    else:
        return 0
print(sum(map(f, m)))


test = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
test2 = test[3:7]
for i in test2:
    i += 1

print(test2)