import sys
sys.stdin = open("input.txt", 'r')
N = int(input())
import collections
d = collections.deque()
d.extend(list(map(int, range(1, N+1))))
while True:
    if len(d) == 1:
        print(d.pop(), end=' ')
        break;
    else:
        print(d.popleft(), end=' ')
        d.rotate(-1)