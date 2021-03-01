import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

l = list(range(1, 21))
for i in sys.stdin:
    a, b = map(int, i.split())
    l = l[:a-1] + (l[b-1:a-2:-1] if a-2 >= 0 else l[b-1::-1]) + l[b:]
print(*l)