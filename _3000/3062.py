import sys
sys.stdin = open("input.txt", 'r')
T, *S = map(str, sys.stdin)
for i in S:
    t = str(int(i)+int(i[::-1]))
    print(['NO', 'YES'][t==t[::-1]])