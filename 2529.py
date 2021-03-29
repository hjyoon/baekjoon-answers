import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

_ = int(input())
S = input().rstrip().split()
a = [i for i in range(10-(len(S)+1), 10)]
b = [i for i in range(len(S), -1, -1)]

r = []
aa = []
bb = []
for v in S:
    if v == '<':
        r.append(a.pop())
    elif v == '>':
        r.append(a.pop())
        while True:
            if len(r) == 0:
                break
            aa.append(r.pop())
while True:
    if len(a) == 0:
        break
    aa.append(a.pop())
while True:
    if len(r) == 0:
        break
    aa.append(r.pop())

r = []
for v in S:
    if v == '>':
        r.append(b.pop())
    elif v == '<':
        r.append(b.pop())
        while True:
            if len(r) == 0:
                break
            bb.append(r.pop())
while True:
    if len(b) == 0:
        break
    bb.append(b.pop())
while True:
    if len(r) == 0:
        break
    bb.append(r.pop())


print(*aa, sep='')
print(*bb, sep='')