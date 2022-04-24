import sys
sys.stdin = open("input.txt", 'r')

N = int(input())
tmp = []
for _ in range(N):
    NAME, DD, MM, YYYY = input().split(); DD = int(DD); MM = int(MM); YYYY = int(YYYY);
    tmp.append((NAME, DD, MM, YYYY))

tmp.sort(key=lambda x: [x[3], x[2], x[1]])
print(tmp[-1][0])
print(tmp[0][0])