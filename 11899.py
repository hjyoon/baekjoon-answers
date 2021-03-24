import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = input().rstrip()
l = []
for v in S:
    if len(l) == 0:
        l.append(v)
        continue
    if v == ')' and l[-1] == '(':
        l.pop()
    else:
        l.append(v)
print(len(l))