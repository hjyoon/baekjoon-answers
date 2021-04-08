import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

N = int(input().rstrip())
S = input().rstrip()
m = [[0] * N for _ in range(N)]
offset = 0
def dc(y, x, gap):
    global offset
    if offset >= len(S):
        return

    if S[offset] == 'Q':
        offset += 1
        dc(y, x, gap//2)
        dc(y, x+gap//2, gap//2)
        dc(y+gap//2, x, gap//2)
        dc(y+gap//2, x+gap//2, gap//2)
        return
    else:
        for i in range(y, y+gap):
            for j in range(x, x+gap):
                m[i][j] = ['0', '1'][S[offset] == 'B']
        offset += 1

dc(0, 0, N)

print(f'#define quadtree_width {N}')
print(f'#define quadtree_height {N}')
print('static char quadtree_bits[] = {')
for v in m:
    for i in range(N//8):
        s = i*8
        e = (i+1)*8
        a = int('0b' + ''.join(v[s:e][::-1]), 2)
        print(f'0x{a:02x},', end='')
    print()
print('};', end='')