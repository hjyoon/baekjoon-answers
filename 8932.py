import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

t = (
    (9.23076, 26.7, 1.835),
    (1.84523, 75, 1.348),
    (56.0211, 1.5, 1.05),
    (4.99087, 42.5, 1.81),
    (0.188807, 210, 1.41),
    (15.9803, 3.8, 1.04),
    (0.11193, 254, 1.88),
)

_, *S = map(lambda x:x.rstrip(), sys.stdin)
for v in S:
    s = tuple(map(int, v.split()))
    sum = 0
    for i, v in enumerate(s):
        if i in (0, 3, 6):
            sum += int(t[i][0]*(t[i][1]-v)**t[i][2])
        else:
            sum += int(t[i][0]*(v-t[i][1])**t[i][2])
            
    print(sum)