import sys
input = sys.stdin.readline

d = {
    0:'{}',
    1:'{{}}',
}

for i in range(2,16):
    tmp = []
    tmp.append('{')
    for j in range(i):
        tmp.append(d[j])
        if j != i-1:
            tmp.append(',')
    tmp.append('}')
        
    d[i] = ''.join(tmp)

for i in range(16):
    tmp = d[i]
    d[tmp] = i


T = int(input())
for _ in range(T):
    a = input().rstrip()
    b = input().rstrip()
    print(d[d[a]+d[b]])