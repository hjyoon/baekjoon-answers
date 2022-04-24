import sys
sys.stdin = open("input.txt", 'r')
input = sys.stdin.readline

R, C = map(int, input().split())

S1 = [[int(i) for i in input().split()] for _ in range(R)]
S2 = [[int(i) for i in input().split()] for _ in range(R)]


def dfs(y, x, s, chk, start):
    if 0 <= y < R and 0 <= x < C and chk[y][x] == 0 and s[y][x] == start:
        chk[y][x] = 1
        dy = [0, 1, 0, -1]
        dx = [1, 0, -1, 0]
        for i in range(4):
            dfs(y+dy[i], x+dx[i], s, chk, start)


def comp(chk1, chk2):
    for i in range(R):
        if chk1[i] != chk2[i]:
            return False
    return True


ans = None
for i in range(R):
    for j in range(C):
        chk1 = [[0]*C for _ in range(R)]
        chk2 = [[0]*C for _ in range(R)]
        dfs(i, j, S1, chk1, S1[i][j])
        #dfs(i, j, S2, chk2, S2[i][j])
        if comp(chk1, chk2):
            ans = True
            print(*chk1, sep='\n')
            #print(*chk2, sep='\n')

if ans:
    print('YES')
else:
    print('No')

# print(*S1, sep='\n')
# print(*S2, sep='\n')
#print(*dif, sep='\n')
#print(*chk, sep='\n')
# print(ans)
