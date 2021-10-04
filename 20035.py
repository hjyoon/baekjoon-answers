import sys
from pprint import pprint
sys.stdin = open('input.txt')
input = sys.stdin.readline

R, C = map(int, input().split())
A = tuple(map(int, input().split()))
B = tuple(map(int, input().split()))

#print(A, B)
max_A = max(A)
max_B = max(B)
front_A_idx = None
end_A_idx = None
B_idx = None
for i in range(R):
    if A[i] == max_A:
        if not front_A_idx:
            front_A_idx = i
        else:
            end_A_idx = i

for i in range(C):
    if B[i] == max_B:
        B_idx = i
        break


#print(front_A_idx, end_A_idx)
# print(B_idx)

pos_y, pos_x = 0, 0
ans = 0
for y in range(front_A_idx+1):
    #print(A[y] * 10**9 + B[pos_x])
    ans += A[y] * 10**9 + B[pos_x]
    pos_y = y

for x in range(pos_x+1, B_idx+1):
    #print(A[pos_y] * 10**9 + B[x])
    ans += A[pos_y] * 10**9 + B[x]
    pos_x = x

for y in range(pos_y+1, end_A_idx+1):
    #print(A[y] * 10**9 + B[pos_x])
    ans += A[y] * 10**9 + B[pos_x]
    pos_y = y

for x in range(pos_x+1, C):
    #print(A[pos_y] * 10**9 + B[x])
    ans += A[pos_y] * 10**9 + B[x]
    pos_x = x

for y in range(pos_y+1, R):
    #print(A[y] * 10**9 + B[pos_x])
    ans += A[y] * 10**9 + B[pos_x]
    pos_y = y

print(ans)
