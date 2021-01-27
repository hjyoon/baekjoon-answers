import sys
sys.stdin = open("input.txt", 'r')

l = list(map(int, sys.stdin))
w = sorted(l[:10], reverse=True)
k = sorted(l[10:], reverse=True)
print(sum(w[:3]), sum(k[:3]))