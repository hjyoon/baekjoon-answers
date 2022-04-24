import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

S = input().rstrip()
l = []
c = {'P':13, 'K':13, 'H':13, 'T':13}
for i in range(0, len(S), 3):
    l.append(S[i:i+3])

for v in l:
    c[v[0]] -= 1

if len(set(l)) != len(l):
    print('GRESKA')
else:
    print(c['P'], c['K'], c['H'], c['T'])