import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

K = int(input().rstrip())
N = int(input().rstrip())
bottom_up = list(input().rstrip())
S = list(map(lambda x:x.rstrip(), sys.stdin))

top_down = list(map(chr, range(65, 65+K)))

#print(top_down)
#print(bottom_up)

for s in S:
    if s[0] == '?':
        break
    else:
        for i, c in enumerate(s):
            if c == '*':
                continue
            else:
                top_down[i], top_down[i+1] = top_down[i+1], top_down[i]

for s in S[::-1]:
    if s[0] == '?':
        break
    else:
        for i, c in enumerate(s):
            if c == '*':
                continue
            else:
                bottom_up[i], bottom_up[i+1] = bottom_up[i+1], bottom_up[i]

# top_down = ['C', 'A', 'B']
# bottom_up = ['C', 'B', 'A']

# top_down = ['A', 'B', 'C']
# bottom_up = ['B', 'A', 'C']

# top_down = ['A', 'B', 'C']
# bottom_up = ['C', 'B', 'A']

# top_down = ['C', 'A', 'B']
# bottom_up = ['B', 'C', 'A']

# top_down = ['A', 'B', 'C']
# bottom_up = ['A', 'B', 'C']

# top_down = ['A', 'B']
# bottom_up = ['A', 'B']

# top_down = ['B', 'A']
# bottom_up = ['A', 'B']

#print(top_down)
#print(bottom_up)
ans = []

i = 0
while i < K-1:
    if top_down[i] == bottom_up[i]:
        ans.extend(['*'])
        i += 1
    else:
        if top_down[i] == bottom_up[i+1] and top_down[i+1] == bottom_up[i]:
            if i >= K-2:
                ans.extend(['-'])
            else:
                ans.extend(['-', '*'])
            i += 2
        else:
            ans.clear()
            ans.extend(['x']*(K-1))
            break
    #print(ans)
print(''.join(ans))